package br.unibratec.heranca.tableperclass.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.unibratec.heranca.tableperclass.entidades.AlunoTablePerClass;
import br.unibratec.heranca.tableperclass.entidades.ProfessorTablePerClass;
import br.unibratec.util.BibliotecaFuncoes;
import br.unibratec.util.UtilJPA;

public class HerancaTablePerClassDAO implements IHerancaTablePerClassDAO {
	
	public void persistir(AlunoTablePerClass pAluno) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		manager.persist(pAluno);
		
		transacao.commit();
		manager.close();
	}
	
	public void persistir(ProfessorTablePerClass pDisciplina) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		
		transacao.begin();
		
		manager.persist(pDisciplina);
		transacao.commit();
		manager.close();
	}
	
	public void persistir(AlunoTablePerClass pAluno, ProfessorTablePerClass pDisciplina) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		
		transacao.begin();
		
		manager.persist(pAluno);
		manager.persist(pDisciplina);
		
		transacao.commit();
		manager.close();
	}

	public AlunoTablePerClass consultarAluno(AlunoTablePerClass pAluno) {
		AlunoTablePerClass aluno = pAluno;
		if (	pAluno != null		&&
				pAluno.getCodigoPessoa() != null
		) {
			EntityManager manager = UtilJPA.getEntityManager();
			
			aluno = manager.find(AlunoTablePerClass.class, pAluno.getCodigoPessoa());
			
			manager.close();
		}
		
		return aluno;
	}

	public AlunoTablePerClass consultarAluno(String pCPF) {
		AlunoTablePerClass aluno = null;
		if (	BibliotecaFuncoes.isStringValida( pCPF )	) {
			EntityManager manager = UtilJPA.getEntityManager();
			
			aluno = manager.find(AlunoTablePerClass.class, pCPF);
			
			manager.close();
		}
		
		return aluno;
	}

	public ProfessorTablePerClass consultarProfessorHeranca(ProfessorTablePerClass pDisciplina) {
		ProfessorTablePerClass disciplina = pDisciplina;
		if (	pDisciplina != null		&&
				pDisciplina.getCodigoPessoa() != null 
		) {
			EntityManager manager = UtilJPA.getEntityManager();
			
			disciplina = manager.find(ProfessorTablePerClass.class, pDisciplina.getCodigoPessoa());
			
			manager.close();
		}
		
		return disciplina;
	}

	public ProfessorTablePerClass consultarProfessorHeranca(String pCdDisciplina) {
		ProfessorTablePerClass disciplina = null;
		if (	BibliotecaFuncoes.isStringValida( pCdDisciplina )		) {
			EntityManager manager = UtilJPA.getEntityManager();
			
			disciplina = manager.find(ProfessorTablePerClass.class, pCdDisciplina);
			
			manager.close();
		}
		
		return disciplina;
	}

	@Override
	public void atualizar(AlunoTablePerClass pAluno, ProfessorTablePerClass pDisciplina) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		manager.merge(pAluno);
		manager.merge(pDisciplina);
		
		transacao.commit();
		manager.close();
	}

	@Override
	public void atualizar(AlunoTablePerClass pAluno) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		manager.merge(pAluno);
		
		transacao.commit();
		manager.close();
	}

	@Override
	public void atualizar(ProfessorTablePerClass pDisciplina) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		manager.merge(pDisciplina);
		
		transacao.commit();
		manager.close();
	}

}
