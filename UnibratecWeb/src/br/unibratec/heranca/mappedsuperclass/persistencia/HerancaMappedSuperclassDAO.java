package br.unibratec.heranca.mappedsuperclass.persistencia;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.unibratec.heranca.mappedsuperclass.entidades.AlunoHerancaMappedSuperclass;
import br.unibratec.heranca.mappedsuperclass.entidades.ProfessorHerancaMappedSuperclass;
import br.unibratec.util.BibliotecaFuncoes;
import br.unibratec.util.UtilJPA;

public class HerancaMappedSuperclassDAO implements IHerancaMappedSuperclassDAO {
	
	public void persistir(AlunoHerancaMappedSuperclass pAluno) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		manager.persist(pAluno);
		
		transacao.commit();
		manager.close();
	}
	
	public void persistir(ProfessorHerancaMappedSuperclass pDisciplina) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		manager.persist(pDisciplina);
		
		transacao.commit();
		manager.close();
	}
	
	public void persistir(AlunoHerancaMappedSuperclass pAluno, ProfessorHerancaMappedSuperclass pDisciplina) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		
		manager.persist(pAluno);
		manager.persist(pDisciplina);
		
		transacao.commit();
		manager.close();
	}

	public AlunoHerancaMappedSuperclass consultarAluno(AlunoHerancaMappedSuperclass pAluno) {
		AlunoHerancaMappedSuperclass aluno = pAluno;
		if (	pAluno != null		&&
				pAluno.getCodigoAluno() != null
		) {
			EntityManager manager = UtilJPA.getEntityManager();
			
			aluno = manager.find(AlunoHerancaMappedSuperclass.class, pAluno.getCodigoAluno());
			
			manager.close();
		}
		
		return aluno;
	}

	public AlunoHerancaMappedSuperclass consultarAluno(String pCPF) {
		AlunoHerancaMappedSuperclass aluno = null;
		if (	BibliotecaFuncoes.isStringValida( pCPF )	) {
			EntityManager manager = UtilJPA.getEntityManager();
			
			aluno = manager.find(AlunoHerancaMappedSuperclass.class, pCPF);
			
			manager.close();
		}
		
		return aluno;
	}
	
	public AlunoHerancaMappedSuperclass getReferenciaAluno(String pCPF) {
		AlunoHerancaMappedSuperclass aluno = null;
		if (	BibliotecaFuncoes.isStringValida( pCPF )	) {
			EntityManager manager = UtilJPA.getEntityManager();
			
			aluno = manager.getReference(AlunoHerancaMappedSuperclass.class, pCPF);
			
			manager.close();
		}
		
		return aluno;
	}

	public ProfessorHerancaMappedSuperclass consultarProfessorHeranca(ProfessorHerancaMappedSuperclass pDisciplina) {
		ProfessorHerancaMappedSuperclass disciplina = pDisciplina;
		if (	pDisciplina != null		&&
				pDisciplina.getCodigoProfessor() != null 
		) {
			EntityManager manager = UtilJPA.getEntityManager();
			
			disciplina = manager.find(ProfessorHerancaMappedSuperclass.class, pDisciplina.getCodigoProfessor());
			
			manager.close();
		}
		
		return disciplina;
	}

	public ProfessorHerancaMappedSuperclass consultarProfessorHeranca(String pCdDisciplina) {
		ProfessorHerancaMappedSuperclass disciplina = null;
		if (	BibliotecaFuncoes.isStringValida( pCdDisciplina )		) {
			EntityManager manager = UtilJPA.getEntityManager();
			
			disciplina = manager.find(ProfessorHerancaMappedSuperclass.class, pCdDisciplina);
			
			manager.close();
		}
		
		return disciplina;
	}

	@Override
	public void atualizar(AlunoHerancaMappedSuperclass pAluno, ProfessorHerancaMappedSuperclass pDisciplina) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		manager.merge(pAluno);
		manager.merge(pDisciplina);
		
		transacao.commit();
		manager.close();
	}

	@Override
	public void atualizar(AlunoHerancaMappedSuperclass pAluno) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		manager.merge(pAluno);
		
		transacao.commit();
		manager.close();
	}
	
	public void removerAluno(String pCPFAluno) {
		EntityManager manager = UtilJPA.getEntityManager();
		
		AlunoHerancaMappedSuperclass aluno = manager.find(AlunoHerancaMappedSuperclass.class, pCPFAluno);
		
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		manager.remove(aluno);
		
		transacao.commit();
		manager.close();
	}

	@Override
	public void atualizar(ProfessorHerancaMappedSuperclass pDisciplina) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		manager.merge(pDisciplina);
		
		transacao.commit();
		manager.close();
	}

	@Override
	public void executarQueryJPQL() {
		EntityManager manager = UtilJPA.getEntityManager();
		
		String consulta = "Select a From AlunoHerancaMappedSuperclass a Where a.codigoAluno Like '1%'";
		
		/*Query query = manager.createQuery(consulta);
		Collection registros = query.getResultList();*/
				
		TypedQuery<AlunoHerancaMappedSuperclass> queryAluno = 
			manager.createQuery(consulta, AlunoHerancaMappedSuperclass.class);
		
		queryAluno.setMaxResults(3);
		Collection<AlunoHerancaMappedSuperclass> alunos = 
			queryAluno.getResultList();
		alunos.toString();
		
		manager.close();
	}
	
	public void executarQueryJPQL(String pCdAluno) {
		EntityManager manager = UtilJPA.getEntityManager();
		
		String consulta = "Select a From AlunoHerancaMappedSuperclass a Where a.codigoAluno = ?0";
		
		TypedQuery<AlunoHerancaMappedSuperclass> queryAluno = 
			manager.createQuery(consulta, AlunoHerancaMappedSuperclass.class);
		
		queryAluno.setParameter(0, pCdAluno);
		
		Collection<AlunoHerancaMappedSuperclass> alunos = 
			queryAluno.getResultList();
		alunos.toString();
		
		manager.close();
	}

}
