package br.unibratec.heranca.singletable.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.unibratec.heranca.singletable.entidades.AlunoSingleTable;
import br.unibratec.heranca.singletable.entidades.ProfessorSingleTable;
import br.unibratec.util.BibliotecaFuncoes;
import br.unibratec.util.UtilJPA;

public class HerancaSingleTableDAO implements IHerancaSingleTableDAO {
	
	public void persistir(AlunoSingleTable pAluno) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		manager.persist(pAluno);
		
		transacao.commit();
		manager.close();
	}
	
	public void persistir(ProfessorSingleTable pDisciplina) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		manager.persist(pDisciplina);
		
		transacao.commit();
		manager.close();
	}
	
	public void persistir(AlunoSingleTable pAluno, ProfessorSingleTable pDisciplina) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		manager.persist(pAluno);
		manager.persist(pDisciplina);
		
		transacao.commit();
		manager.close();
	}

	public AlunoSingleTable consultarAluno(AlunoSingleTable pAluno) {
		AlunoSingleTable aluno = pAluno;
		if (	pAluno != null		&&
				pAluno.getCodigoPessoa() != null
		) {
			EntityManager manager = UtilJPA.getEntityManager();
			
			aluno = manager.find(AlunoSingleTable.class, pAluno.getCodigoPessoa());
			
			manager.close();
		}
		
		return aluno;
	}

	public AlunoSingleTable consultarAluno(String pCPF) {
		AlunoSingleTable aluno = null;
		if (	BibliotecaFuncoes.isStringValida( pCPF )	) {
			EntityManager manager = UtilJPA.getEntityManager();
			
			aluno = manager.find(AlunoSingleTable.class, pCPF);
			
			manager.close();
		}
		
		return aluno;
	}

	public ProfessorSingleTable consultarProfessorHeranca(ProfessorSingleTable pDisciplina) {
		ProfessorSingleTable disciplina = pDisciplina;
		if (	pDisciplina != null		&&
				pDisciplina.getCodigoPessoa() != null 
		) {
			EntityManager manager = UtilJPA.getEntityManager();
			
			disciplina = manager.find(ProfessorSingleTable.class, pDisciplina.getCodigoPessoa());
			
			manager.close();
		}
		
		return disciplina;
	}

	public ProfessorSingleTable consultarProfessorHeranca(String pCdDisciplina) {
		ProfessorSingleTable disciplina = null;
		if (	BibliotecaFuncoes.isStringValida( pCdDisciplina )		) {
			EntityManager manager = UtilJPA.getEntityManager();
			
			disciplina = manager.find(ProfessorSingleTable.class, pCdDisciplina);
			
			manager.close();
		}
		
		return disciplina;
	}

	@Override
	public void atualizar(AlunoSingleTable pAluno, ProfessorSingleTable pDisciplina) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		manager.merge(pAluno);
		manager.merge(pDisciplina);
		
		transacao.commit();
		manager.close();
	}

	@Override
	public void atualizar(AlunoSingleTable pAluno) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		manager.merge(pAluno);
		
		transacao.commit();
		manager.close();
	}

	@Override
	public void atualizar(ProfessorSingleTable pDisciplina) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		manager.merge(pDisciplina);
		
		transacao.commit();
		manager.close();
	}

}