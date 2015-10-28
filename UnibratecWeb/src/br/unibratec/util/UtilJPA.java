package br.unibratec.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;

public class UtilJPA {
	
	private static final EntityManagerFactory emf = 
		Persistence.createEntityManagerFactory(ConstantesGerais.PERSISTENCE_UNIT_UNIBRATEC);
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public static void closeEntityManagerFactory() {
		emf.close();
	}
	
	public static Statistics getStatistics() {
		EntityManager em = getEntityManager();
		
		Session session = (Session) em.getDelegate();
		SessionFactory sf = session.getSessionFactory();
		
		Statistics statistics = sf.getStatistics();
		
		return statistics;
	}
	
}
