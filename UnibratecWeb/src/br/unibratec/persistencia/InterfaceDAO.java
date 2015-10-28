package br.unibratec.persistencia;

import javax.persistence.EntityManager;

import br.unibratec.entidades.Entidade;

public interface InterfaceDAO {
	
	public void inserir(Entidade pEntidade);
	public void inserir(Entidade pEntidade, EntityManager pEntityManager, boolean pFecharEntityManager);
	
	public void alterar(Entidade pEntidade);
	public void alterar(Entidade pEntidade, EntityManager pEntityManager, boolean pFecharEntityManager);
	
	
	public void excluirPorChavePrimaria(Class pClasse, Object pPrimaryKey);
	public void excluirPorChavePrimaria(Class pClasse, Object pPrimaryKey, EntityManager pEntityManager, boolean pFecharEntityManager);
	
	public void excluirPorObjeto(Entidade pEntidade);
	public void excluirPorObjeto(Entidade pEntidade, EntityManager pEntityManager, boolean pFecharEntityManager);
	public void excluirPorObjetoSemConsultarAntes(
		Entidade		pEntidade, 
		EntityManager	pEntityManager, 
		boolean			pFecharEntityManager);
	
	public Entidade consultarPorChavePrimaria(Class pClasse, Object pPrimaryKey);
	public Entidade consultarPorChavePrimaria(Class pClasse, Object pPrimaryKey, EntityManager pEntityManager, boolean pFecharEntityManager);
	
	public Entidade consultarPorObjeto(Entidade pEntidade);
	public Entidade consultarPorObjeto(Entidade pEntidade, EntityManager pEntityManager, boolean pFecharEntityManager);
	
}