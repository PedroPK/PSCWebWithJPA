package br.unibratec.relacionamentos.manytoone.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.unibratec.relacionamentos.manytoone.entidades.Autor;
import br.unibratec.relacionamentos.manytoone.entidades.Monografia;
import br.unibratec.util.BibliotecaFuncoes;
import br.unibratec.util.UtilJPA;

public class MonografiaDAO implements IMonografiaDAO {
	
	public void persistir(Monografia pMonografia, Autor pAutor) {
		persistirAutor(pAutor);
		persistir(pMonografia);
		
		UtilJPA.closeEntityManagerFactory();
	}
	
	public void persistir(Monografia pMonografia) {
		EntityManager manager = UtilJPA.getEntityManager();
		
		EntityTransaction transacao = manager.getTransaction();
		
		transacao.begin();
		
		manager.persist(pMonografia);
		
		transacao.commit();
		
		manager.close();
	}
	
	public void persistirAutor(Autor pAutor) {
		EntityManager manager = UtilJPA.getEntityManager();
		
		EntityTransaction transacao = manager.getTransaction();
		
		transacao.begin();
		
		manager.persist(pAutor);
		
		transacao.commit();
		
		manager.close();
	}
	
	public void consultarAutor(Autor pAutor) {
		if (	pAutor != null &&
				BibliotecaFuncoes.isStringValida(pAutor.getCodigoAutor())
		) {
			EntityManager manager = UtilJPA.getEntityManager();
			
			Autor autor = manager.find(Autor.class, pAutor.getCodigoAutor());
			autor.toString();
			
			manager.close();
		}
	}
	
	public void consultarAutor(String pCdAutor) {
		if (	BibliotecaFuncoes.isStringValida(pCdAutor) 		) {
			EntityManager manager = UtilJPA.getEntityManager();
			
			Autor autor = manager.find(Autor.class, pCdAutor);
			autor.toString();
			
			manager.close();
		}
	}
	
	
	public void consultarMonografia(Monografia pMonografia) {
		if (	pMonografia != null &&
				pMonografia.getDoi() != null
		) {
			EntityManager manager = UtilJPA.getEntityManager();
			
			Monografia monografia = manager.find(Monografia.class, pMonografia.getDoi());
			monografia.toString();
			
			manager.close();
		}
	}
	
	public void consultarMonografia(Long pCdMonografia) {
		if (	pCdMonografia != null	) {
			EntityManager manager = UtilJPA.getEntityManager();
			
			Monografia monografia = manager.find(Monografia.class, pCdMonografia);
			monografia.toString();
			
			manager.close();
		}
	}
	
}