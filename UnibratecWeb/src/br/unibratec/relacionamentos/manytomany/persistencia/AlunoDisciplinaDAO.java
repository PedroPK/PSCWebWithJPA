package br.unibratec.relacionamentos.manytomany.persistencia;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.unibratec.relacionamentos.manytomany.entidades.Aluno;
import br.unibratec.relacionamentos.manytomany.entidades.AlunoQtDisciplinas;
import br.unibratec.relacionamentos.manytomany.entidades.Disciplina;
import br.unibratec.util.BibliotecaFuncoes;
import br.unibratec.util.UtilJPA;

public class AlunoDisciplinaDAO implements IAlunoDisciplinaDAO {
	
	public void persistir(Aluno pAluno) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		manager.persist(pAluno);
		
		transacao.commit();
		manager.close();
	}
	
	public void persistir(Disciplina pDisciplina) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		manager.persist(pDisciplina);
		
		transacao.commit();
		
		manager.close();
	}
	
	public void persistir(Aluno pAluno, Disciplina pDisciplina) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		manager.persist(pAluno);
		manager.persist(pDisciplina);
		
		transacao.commit();
		
		manager.close();
	}

	public Aluno consultarAluno(Aluno pAluno) {
		Aluno aluno = pAluno;
		if (	pAluno != null		&&
				BibliotecaFuncoes.isStringValida( pAluno.getCpf() )
		) {
			EntityManager manager = UtilJPA.getEntityManager();
			
			aluno = manager.find(Aluno.class, pAluno.getCpf());
			
			manager.close();
		}
		
		return aluno;
	}

	public Aluno consultarAluno(String pCPF) {
		Aluno aluno = null;
		if (	BibliotecaFuncoes.isStringValida( pCPF )	) {
			EntityManager manager = UtilJPA.getEntityManager();
			
			aluno = manager.find(Aluno.class, pCPF);
			
			manager.close();
		}
		
		return aluno;
	}

	public Disciplina consultarDisciplina(Disciplina pDisciplina) {
		Disciplina disciplina = pDisciplina;
		if (	pDisciplina != null		&&
				BibliotecaFuncoes.isStringValida( pDisciplina.getCodigo() )
		) {
			EntityManager manager = UtilJPA.getEntityManager();
			
			disciplina = manager.find(Disciplina.class, pDisciplina.getCodigo());
			
			manager.close();
		}
		
		return disciplina;
	}

	public Disciplina consultarDisciplina(String pCdDisciplina) {
		Disciplina disciplina = null;
		if (	BibliotecaFuncoes.isStringValida( pCdDisciplina )		) {
			EntityManager manager = UtilJPA.getEntityManager();
			
			disciplina = manager.find(Disciplina.class, pCdDisciplina);
			
			manager.close();
		}
		
		return disciplina;
	}

	@Override
	public void atualizar(Aluno pAluno, Disciplina pDisciplina) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		manager.merge(pAluno);
		manager.merge(pDisciplina);
		
		transacao.commit();
		manager.close();
	}

	@Override
	public void atualizar(Aluno pAluno) {
		/*EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		manager.merge(pAluno);*/
		
		
		/*Session sessaoHibernate = BibliotecaFuncoes.createSessionHibernate().openSession();
		org.hibernate.Transaction transacaoHibernate = sessaoHibernate.beginTransaction();
		
		sessaoHibernate.merge(pAluno);
		Cache cacheHibernate = sessaoHibernate.getSessionFactory().getCache();
		cacheHibernate.evictQueryRegion(Aluno.ALUNO_REGIAO_CACHE_CONSULTA_PSC);
		
		transacaoHibernate.commit();
		sessaoHibernate.close();*/
		
		/*transacao.commit();
		manager.close();*/
	}

	@Override
	public void atualizar(Disciplina pDisciplina) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		manager.merge(pDisciplina);
		
		transacao.commit();
		manager.close();
	}

	@Override
	public void executarQueryJPQLComJoin() {
		EntityManager manager = UtilJPA.getEntityManager();
		
		String stringQueryComJoin = "Select a From Aluno a Join a.disciplinasMatriculadas d Where d.descricao Like 'PSC%'";
		TypedQuery<Aluno> queryComJoin = manager.createQuery(stringQueryComJoin, Aluno.class);
		Collection<Aluno> alunosPSC = queryComJoin.getResultList();
		alunosPSC.toString();
		
		manager.close();
	}
	
	public void executarQueryJPQLComColunasExtras() {
		EntityManager manager = UtilJPA.getEntityManager();
		
		String stringQueryComColunaExtra = "Select a, size(disciplinasMatriculadas) From Aluno a";
		Query queryComColunaExtra = manager.createQuery(stringQueryComColunaExtra);
		Collection alunos = queryComColunaExtra.getResultList();
		alunos.toString();
		
		manager.close();
	}
	
	public void executarQueryJPQLComColunasExtrasTipada() {
		EntityManager manager = UtilJPA.getEntityManager();
		
		String stringQueryComColunaExtraTipada = "Select new br.unibratec.relacionamentos.manytomany.entidades.AlunoQtDisciplinas( a, size(disciplinasMatriculadas)) From Aluno a";
		TypedQuery<AlunoQtDisciplinas> queryComColunaExtraTipada = 
			manager.createQuery(
				stringQueryComColunaExtraTipada,
				AlunoQtDisciplinas.class);
		Collection<AlunoQtDisciplinas> alunos = queryComColunaExtraTipada.getResultList();
		alunos.toString();
		
		manager.close();
	}
	
	public void executarNamedQueryAlunosPSC() {
		EntityManager manager = UtilJPA.getEntityManager();
		
		TypedQuery<Aluno> namedQuery= 
			manager.createNamedQuery(
				Aluno.CONSULTA_ALUNOS_PSC, 
				Aluno.class);
		Collection<Aluno> alunosPSC = namedQuery.getResultList();
		alunosPSC.toString();
		
		manager.close();
	}
	
	public void executarQueryParametrizada() {
		EntityManager manager = UtilJPA.getEntityManager();
		
		String stringQueryParametrizada =	"Select a From Aluno a Join a.disciplinasMatriculadas d Where d.descricao = :descricaoDisciplina";
		
		TypedQuery<Aluno> queryParametrizada= 
			manager.createQuery(
				stringQueryParametrizada, 
				Aluno.class);
		queryParametrizada.setParameter("descricaoDisciplina", "PSC");
		
		Collection<Aluno> alunosPSC = queryParametrizada.getResultList();
		alunosPSC.toString();
		
		manager.close();
	}
	
	public void executarQueryComCache2oNivel() {
		EntityManager manager = UtilJPA.getEntityManager();
		TypedQuery<Aluno> tqAluno = 
			manager.createNamedQuery(
				Aluno.CONSULTA_ALUNOS_PSC, 
				Aluno.class);
		
		String regiaoCache = Aluno.ALUNO_REGIAO_CACHE_CONSULTA_PSC;
		BibliotecaFuncoes.habilitarRegiaoCacheQuery(tqAluno, regiaoCache);
		
		Collection<Aluno> alunosPSC = tqAluno.getResultList();
		alunosPSC.toString();
	}

}