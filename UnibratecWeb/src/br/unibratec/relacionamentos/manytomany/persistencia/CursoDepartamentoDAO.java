package br.unibratec.relacionamentos.manytomany.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.unibratec.relacionamentos.manytomany.entidades.Curso;
import br.unibratec.relacionamentos.manytomany.entidades.Departamento;
import br.unibratec.util.BibliotecaFuncoes;
import br.unibratec.util.UtilJPA;

public class CursoDepartamentoDAO implements ICursoDepartamentoDAO {
	
	@Override
	public void persistir(Curso pCurso, Departamento pDepartamento) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		manager.persist(pCurso);
		manager.persist(pDepartamento);
		
		transacao.commit();
		manager.close();
		UtilJPA.closeEntityManagerFactory();
	}
	
	@Override
	public void persistir(Curso pCurso) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		manager.persist(pCurso);
		
		transacao.commit();
		manager.close();
		UtilJPA.closeEntityManagerFactory();
	}
	
	@Override
	public void persistir(Departamento pDepartamento) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		manager.persist(pDepartamento);
		
		transacao.commit();
		manager.close();
		UtilJPA.closeEntityManagerFactory();
		
	}
	
	@Override
	public void consultarCurso(Curso pCurso) {
		if (	pCurso != null		&&
				pCurso.getIdCurso() != null
		) {
			EntityManager manager = UtilJPA.getEntityManager();
			Curso c = manager.find(Curso.class, pCurso);
			c.toString();
		}
	}
	
	@Override
	public void consultarCurso(String pCdCurso) {
		if (	BibliotecaFuncoes.isStringValida(pCdCurso)		) {
			EntityManager manager = UtilJPA.getEntityManager();
			Curso c = manager.find(Curso.class, pCdCurso);
			c.toString();
		}
	}
	
	@Override
	public void consultarDepartamento(Departamento pDepartamento) {
		if (	pDepartamento != null		&&
				pDepartamento.getIdDepartamento() != null
		) {
			EntityManager manager = UtilJPA.getEntityManager();
			Departamento d = manager.find(Departamento.class, pDepartamento);
			d.toString();
		}
	}
	
	@Override
	public void consultarDepartamento(String pCdDepartamento) {
		if (	BibliotecaFuncoes.isStringValida(pCdDepartamento)		) {
			EntityManager manager = UtilJPA.getEntityManager();
			Departamento d = manager.find(Departamento.class, pCdDepartamento);
			d.toString();
		}
	}
	
}