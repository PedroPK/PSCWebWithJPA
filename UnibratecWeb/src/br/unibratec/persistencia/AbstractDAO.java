package br.unibratec.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.unibratec.entidades.Entidade;
import br.unibratec.util.UtilJPA;

public abstract class AbstractDAO implements InterfaceDAO {
	
	/*
	 * Versão anterior do método abaixo
	 * 
	 * 
	public void inserir(Entidade pEntidade) {
		EntityManager manager = UtilJPA.getEntityManager();
		inserir(pObject, manager, true);
	}
	*/
	public void inserir(Entidade pEntidade) {
		inserir(pEntidade, UtilJPA.getEntityManager(), true);
	}
	
	public void inserir(Entidade pEntidade, EntityManager pEntityManager, boolean pFecharEntityManager) {
		EntityTransaction transacao = pEntityManager.getTransaction();
		transacao.begin();
		
		pEntityManager.persist(pEntidade);
		
		transacao.commit();
		
		if ( pFecharEntityManager ) {
			pEntityManager.close();
		}
	}
	
	/*
	 * Versão anterior do método abaixo
	 * 
	 * 
	public void alterar(Entidade pEntidade) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		manager.merge(pObject);
		
		transacao.commit();
		manager.close();
	}*/
	public void alterar(Entidade pEntidade) {
		alterar(pEntidade, UtilJPA.getEntityManager(), true);
	}
	
	public void alterar(Entidade pEntidade, EntityManager pEntityManager, boolean pFecharEntityManager) {
		EntityTransaction transacao = pEntityManager.getTransaction();
		transacao.begin();
		
		pEntityManager.merge(pEntidade);
		
		transacao.commit();
		
		if ( pFecharEntityManager ) {
			pEntityManager.close();
		}
	}
	
	/*
	 * Versão anterior do método abaixo
	 * 
	 * 
	public void excluirPorObjeto(Class pClasse, Entidade pEntidade) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		Object registro = manager.find(pClasse, pEntidade.getChavePrimaria());
		manager.remove(registro);
		
		transacao.commit();
		manager.close();
	}
	/*/
	public void excluirPorObjeto(Entidade pEntidade) {
		excluirPorObjeto(pEntidade, UtilJPA.getEntityManager(), true);
	}
	public void excluirPorObjeto(
		Entidade		pEntidade, 
		EntityManager	pEntityManager, 
		boolean			pFecharEntityManager
	) {
		EntityTransaction transacao = pEntityManager.getTransaction();
		transacao.begin();
		
		Object registro = pEntityManager.find(pEntidade.getClass(), pEntidade.getChavePrimaria());
		pEntityManager.remove(registro);
		
		transacao.commit();
		
		if ( pFecharEntityManager ) {
			pEntityManager.close();
		}
	}
	
	/**
	 * TODO Vai dar erro!
	 * 
	 * @param pClasse
	 * @param pEntidade
	 * @param pEntityManager
	 * @param pFecharEntityManager
	 */
	public void excluirPorObjetoSemConsultarAntes(
		Entidade		pEntidade, 
		EntityManager	pEntityManager, 
		boolean			pFecharEntityManager
	) {
		EntityTransaction transacao = pEntityManager.getTransaction();
		transacao.begin();
		
		pEntityManager.remove(pEntidade);
		
		transacao.commit();
		
		if ( pFecharEntityManager ) {
			pEntityManager.close();
		}
	}
	
	/*
	 * Versão anterior do método abaixo
	 * 
	 * 
	public void excluirPorChavePrimaria(Class pClasse, Object pChavePrimaria) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		Object registro = manager.find(pClasse, pChavePrimaria);
		manager.remove(registro);
		
		transacao.commit();
		manager.close();
	}
	*/
	public void excluirPorChavePrimaria(Class pClasse, Object pChavePrimaria) {
		excluirPorChavePrimaria(pClasse, pChavePrimaria, UtilJPA.getEntityManager(), true);
	}
	public void excluirPorChavePrimaria(
		Class			pClasse, 
		Object			pChavePrimaria, 
		EntityManager	pEntityManager, 
		boolean			pFecharEntityManager
	) {
		EntityTransaction transacao = pEntityManager.getTransaction();
		transacao.begin();
		
		Object registro = pEntityManager.find(pClasse, pChavePrimaria);
		pEntityManager.remove(registro);
		
		transacao.commit();
		if ( pFecharEntityManager ) {
			pEntityManager.close();
		}
	}
	public void excluirPorChavePrimaria(
		Class				pClasse, 
		Object				pChavePrimaria, 
		EntityManager		pEntityManager, 
		EntityTransaction	pTransacao,
		boolean				pFecharEntityManager
	) {
		EntityTransaction transacao = pEntityManager.getTransaction();
		transacao.begin();
		
		Object registro = pEntityManager.find(pClasse, pChavePrimaria);
		pEntityManager.remove(registro);
		
		transacao.commit();
		if ( pFecharEntityManager ) {
			pEntityManager.close();
		}
	}
	
	/*
	 * Versão anterior do método abaixo
	 * 
	 * 
	public Object consultar(Class pClasse, Object pPrimaryKey) {
		EntityManager manager = UtilJPA.getEntityManager();
		
		Object registro = manager.find(pClasse, pPrimaryKey);
		
		manager.close();
		return registro;
	}
	*/
	public Entidade consultarPorChavePrimaria(Class pClasse, Object pPrimaryKey) {
		return consultarPorChavePrimaria(pClasse, pPrimaryKey, UtilJPA.getEntityManager(), true);
	}
	public Entidade consultarPorChavePrimaria(Class pClasse, Object pPrimaryKey, EntityManager pEntityManager, boolean pFecharEntityManager) {
		Entidade registro = (Entidade) pEntityManager.find(pClasse, pPrimaryKey);
		
		if ( pFecharEntityManager ) {
			pEntityManager.close();
		}
		
		return registro;
	}
	

	/*
	 * (non-Javadoc)
	 * @see br.unibratec.persistencia.InterfaceDAO#consultarPorObjeto(br.unibratec.entidades.Entidade)
	 */
	public Entidade consultarPorObjeto(Entidade pEntidade) {
		return consultarPorObjeto(pEntidade, UtilJPA.getEntityManager(), true);
	}
	public Entidade consultarPorObjeto(Entidade pEntidade, EntityManager pEntityManager, boolean pFecharEntityManager) {
		Entidade registro = (Entidade) pEntityManager.find(pEntidade.getClass(), pEntidade.getChavePrimaria());
		
		if ( pFecharEntityManager ) {
			pEntityManager.close();
		}
		
		return registro;
	}
	
}