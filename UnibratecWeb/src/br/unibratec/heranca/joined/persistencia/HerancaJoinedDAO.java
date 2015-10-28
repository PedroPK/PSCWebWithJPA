package br.unibratec.heranca.joined.persistencia;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.unibratec.heranca.joined.entidades.AlunoJoined;
import br.unibratec.heranca.joined.entidades.ProfessorJoined;
import br.unibratec.util.BibliotecaFuncoes;
import br.unibratec.util.UtilJPA;

public class HerancaJoinedDAO implements IHerancaJoinedDAO {
	
	public void executarQueryComJoin() {
		EntityManager manager = UtilJPA.getEntityManager();
		
		String stringQueryComJoin = "Select a From AlunoJoined a Join PessoaJoined p";
		
		Query queryComJoin = manager.createQuery(stringQueryComJoin);
		Collection registros = queryComJoin.getResultList();
		
		manager.close();
	}
	
	public void persistir(AlunoJoined pAluno) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		manager.persist(pAluno);
		
		transacao.commit();
		manager.close();
	}
	
	public void persistir(ProfessorJoined pDisciplina) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		
		transacao.begin();
		
		manager.persist(pDisciplina);
		transacao.commit();
		manager.close();
	}
	
	public void persistir(AlunoJoined pAluno, ProfessorJoined pDisciplina) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		
		transacao.begin();
		
		manager.persist(pAluno);
		manager.persist(pDisciplina);
		
		transacao.commit();
		manager.close();
	}

	public AlunoJoined consultarAluno(AlunoJoined pAluno) {
		AlunoJoined aluno = pAluno;
		if (	pAluno != null		&&
				pAluno.getCodigoPessoa() != null
		) {
			EntityManager manager = UtilJPA.getEntityManager();
			
			aluno = manager.find(AlunoJoined.class, pAluno.getCodigoPessoa());
			
			manager.close();
		}
		
		return aluno;
	}

	public AlunoJoined consultarAluno(String pCPF) {
		AlunoJoined aluno = null;
		if (	BibliotecaFuncoes.isStringValida( pCPF )	) {
			EntityManager manager = UtilJPA.getEntityManager();
			
			aluno = manager.find(AlunoJoined.class, pCPF);
			
			manager.close();
		}
		
		return aluno;
	}

	public ProfessorJoined consultarProfessorHeranca(ProfessorJoined pDisciplina) {
		ProfessorJoined disciplina = pDisciplina;
		if (	pDisciplina != null		&&
				pDisciplina.getCodigoPessoa() != null 
		) {
			EntityManager manager = UtilJPA.getEntityManager();
			
			disciplina = manager.find(ProfessorJoined.class, pDisciplina.getCodigoPessoa());
			
			manager.close();
		}
		
		return disciplina;
	}

	public ProfessorJoined consultarProfessorHeranca(String pCdDisciplina) {
		ProfessorJoined disciplina = null;
		if (	BibliotecaFuncoes.isStringValida( pCdDisciplina )		) {
			EntityManager manager = UtilJPA.getEntityManager();
			
			disciplina = manager.find(ProfessorJoined.class, pCdDisciplina);
			
			manager.close();
		}
		
		return disciplina;
	}

	@Override
	public void atualizar(AlunoJoined pAluno, ProfessorJoined pDisciplina) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		manager.merge(pAluno);
		manager.merge(pDisciplina);
		
		transacao.commit();
		manager.close();
	}

	@Override
	public void atualizar(AlunoJoined pAluno) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		manager.merge(pAluno);
		
		transacao.commit();
		manager.close();
	}

	@Override
	public void atualizar(ProfessorJoined pDisciplina) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		manager.merge(pDisciplina);
		
		transacao.commit();
		manager.close();
	}

}
