package br.unibratec.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.internal.BootstrapServiceRegistryImpl;
import org.hibernate.service.internal.StandardServiceRegistryImpl;

import br.unibratec.relacionamentos.manytomany.entidades.Aluno;

public class BibliotecaFuncoes {
	
	public static boolean isStringValida(String pString) {
		boolean resposta = false;
		
		if ( pString != null && pString.trim().length() > 0 ) {
			resposta = true;
		}
		
		return resposta;
	}
	
	public static boolean isDataValida(String pData) {
		boolean resposta = false;
		
		if ( isStringValida(pData) ) {
			try {
				new SimpleDateFormat("dd/MM/yyyy").parse(pData);
				resposta = true;
			} catch (ParseException e) {
				resposta = false;
				e.printStackTrace();
			}
		}
		
		return resposta;
	}
	public static Date getData(String pData) {
		Date data = null;
		
		if ( isDataValida(pData) ) {
			try {
				data = new SimpleDateFormat("dd/MM/yyyy").parse(pData);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		return data;
	}
	
	public static boolean isColecaoValida(Collection pColecao) {
		boolean resposta = false;
		if ( pColecao != null && !pColecao.isEmpty() ) {
			resposta = true;
		}
		
		return resposta;
	}
	
	public static boolean isColecaoValida(Collection pColecao, int pIndice) {
		boolean resposta = false;
		
		if ( isColecaoValida(pColecao) && pColecao.size() > pIndice ) {
			resposta = true;
		}
		
		return resposta;
	}
	
	public static boolean isArrayValido(Object[] pArray) {
		boolean resposta = false;
		if ( pArray != null && pArray.length > 0 ) {
			resposta = true;
		}
		
		return resposta;
	}
	
	public static boolean isArrayValido(Object[] pArray, int pIndice) {
		boolean resposta = false;
		
		if ( isArrayValido(pArray) && pArray.length > pIndice ) {
			resposta = true;
		}
		
		return resposta;
	}
	
	public static void habilitarRegiaoCacheQuery(TypedQuery<Aluno> pTypedQuery, String pRegiaoCache) {
		pTypedQuery.setHint(ConstantesGerais.ORG_HIBERNATE_CACHEABLE, ConstantesGerais.TRUE_STRING);
		pTypedQuery.setHint(ConstantesGerais.ORG_HIBERNATE_CACHE_REGION, pRegiaoCache);
	}
	
	public static void habilitarRegiaoCacheQuery(Query pQuery, String pRegiaoCache) {
		pQuery.setHint(ConstantesGerais.ORG_HIBERNATE_CACHEABLE, ConstantesGerais.TRUE_STRING);
		pQuery.setHint(ConstantesGerais.ORG_HIBERNATE_CACHE_REGION, pRegiaoCache);
	}
	
	public static SessionFactory createSessionHibernate_4_2_21() {
		SessionFactory sessionFactory;
		
		ServiceRegistry registro = new BootstrapServiceRegistryImpl();
		Configuration configuracoes = new Configuration().configure("/META-ING/hibernate.cfg.xml");
		sessionFactory = configuracoes.buildSessionFactory(registro);
		
		return sessionFactory;
		
		//sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	/*public static SessionFactory createSessionHibernate_4_3_11() {
		Configuration configuracoes = new Configuration().configure("/META-INF/hibernate.cfg.xml");
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder.applySettings(configuracoes.getProperties());
		ServiceRegistry registro = builder.build();
		SessionFactory factory = configuracoes.buildSessionFactory(registro);
		return factory;
	}*/
	
	public static String getBooleanComoSimOuNao(boolean pBoolean) {
		String resposta = "Não";
		if ( pBoolean ) {
			resposta = "Sim";
		}
		
		return resposta;
	}
	
}