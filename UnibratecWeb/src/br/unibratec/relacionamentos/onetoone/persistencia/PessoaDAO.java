package br.unibratec.relacionamentos.onetoone.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import br.unibratec.persistencia.AbstractDAO;
import br.unibratec.relacionamentos.onetoone.entidades.DadosPessoais;
import br.unibratec.relacionamentos.onetoone.entidades.Pessoa;
import br.unibratec.util.BibliotecaFuncoes;
import br.unibratec.util.UtilJPA;

public class PessoaDAO extends AbstractDAO implements IPessoaDAO {
	
	public void persistir(Pessoa pPessoa, DadosPessoais pDadosPessoais) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		manager.persist(pPessoa);
		manager.persist(pDadosPessoais);
		
		transacao.commit();
		
		manager.close();
	}
	
	public void persistirPessoa(Pessoa pPessoa) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		manager.persist(pPessoa);
		
		transacao.commit();
		
		manager.close();
	}
	
	public void persistirDadosPessoais(DadosPessoais pDadosPessoais) {
		EntityManager manager = UtilJPA.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		manager.persist(pDadosPessoais);
		
		transacao.commit();
		
		manager.close();
	}
	
	public void consultarDadosPessoais(DadosPessoais pDadosPessoais) {
		if (	pDadosPessoais != null &&
				BibliotecaFuncoes.isStringValida(pDadosPessoais.getCpf())
		) {
			EntityManager manager = UtilJPA.getEntityManager();
			
			DadosPessoais dadosPessoais = manager.find(DadosPessoais.class, pDadosPessoais);
			dadosPessoais.toString();
			
			manager.close();
		}
	}
	
	public void consultarDadosPessoais(String pCPF) {
		if (	BibliotecaFuncoes.isStringValida(pCPF)	) {
			EntityManager manager = UtilJPA.getEntityManager();
			
			DadosPessoais dadosPessoais = manager.find(DadosPessoais.class, pCPF);
			dadosPessoais.toString();
			
			manager.close();
		}
	}
	
	public void consultarPessoa(Pessoa pPessoa) {
		if (	pPessoa != null		&&
				BibliotecaFuncoes.isStringValida( pPessoa.getCpf() )
		) {
			EntityManager manager = UtilJPA.getEntityManager();
			
			Pessoa pessoa = manager.find(Pessoa.class, pPessoa);
			pessoa.toString();
			
			manager.close();
		}
	}
	
	public void consultarPessoa(String pCPF) {
		if (	BibliotecaFuncoes.isStringValida(pCPF)	) {
			EntityManager manager = UtilJPA.getEntityManager();
			
			Pessoa pessoa = manager.find(Pessoa.class, pCPF);
			pessoa.toString();
			
			manager.close();
		}
	}
	
	public void consultarNamedNativeQueryComMapeamento() {
		EntityManager manager = UtilJPA.getEntityManager();
		
		Query query = manager.createNamedQuery(Pessoa.NM_QUERY_NATIVA);
		Collection resultSet = query.getResultList();
		if ( BibliotecaFuncoes.isColecaoValida(resultSet) ) {
			Iterator iterador = resultSet.iterator();
			
			while ( iterador.hasNext() ) {
				Object[] objetosColuna = (Object[]) iterador.next();
				
				if ( BibliotecaFuncoes.isArrayValido(objetosColuna, 1) ) {
					Pessoa pessoa = (Pessoa) objetosColuna[0];
					DadosPessoais dadosPessoais = (DadosPessoais) objetosColuna[1];
					
					pessoa.toString();
					dadosPessoais.toString();
				}
			}
		}
		
		manager.close();
	}

	@Override
	public void consultarPessoaParametrizando(
		String pCPF, 
		String pEndereco,
		String pNome,
		String pDtNascimento
	) {
		EntityManager manager = UtilJPA.getEntityManager();
		
		String stringQueryParametrizadaPessoa = 
			"Select p From Pessoa p Join p.dadosPessoais dp Where p.cpf = dp.cpf";
		String and = " AND ";
		if ( BibliotecaFuncoes.isStringValida(pCPF) ) {
			stringQueryParametrizadaPessoa = stringQueryParametrizadaPessoa + and +
				"p.cpf = :cpf";
			
			and = " AND ";
		};
		
		if ( BibliotecaFuncoes.isStringValida(pEndereco) ) {
			stringQueryParametrizadaPessoa = stringQueryParametrizadaPessoa + and +
				"p.endereco = :endereco";
			
			and = " AND ";
		};
		
		if ( BibliotecaFuncoes.isStringValida(pNome) ) {
			stringQueryParametrizadaPessoa = stringQueryParametrizadaPessoa + and +
				"dp.nome = :nome";
			
			and = " AND ";
		};
		if ( BibliotecaFuncoes.isDataValida(pDtNascimento) ) {
			stringQueryParametrizadaPessoa = stringQueryParametrizadaPessoa + and +
				"dp.dataNascimento = :dataNascimento";
			
			and = " AND ";
		};
		
		System.out.println(stringQueryParametrizadaPessoa);
		
		TypedQuery<Pessoa> queryParametrizadaPessoa =
			manager.createQuery(stringQueryParametrizadaPessoa, Pessoa.class);
		
		if ( BibliotecaFuncoes.isStringValida(pCPF) ) {
			queryParametrizadaPessoa.setParameter("cpf", pCPF);
		};
		
		if ( BibliotecaFuncoes.isStringValida(pEndereco) ) {
			queryParametrizadaPessoa.setParameter("endereco", pEndereco);
		};
		
		if ( BibliotecaFuncoes.isStringValida(pNome) ) {
			queryParametrizadaPessoa.setParameter("nome", pNome);
		};
		
		if ( BibliotecaFuncoes.isStringValida(pDtNascimento) ) {
			queryParametrizadaPessoa.setParameter("dataNascimento", BibliotecaFuncoes.getData(pDtNascimento));
		};
		
		Collection<Pessoa> pessoas = 
			queryParametrizadaPessoa.getResultList();
		pessoas.toString();
		
		manager.close();
	}
	
	public void consultarPessoaComCriteria(
		String pCPF, 
		String pEndereco,
		String pNome,
		String pDtNascimento
	) {
		EntityManager manager = UtilJPA.getEntityManager();
		
		CriteriaBuilder builderCriteria = manager.getCriteriaBuilder();
		CriteriaQuery<Pessoa> queryCriteria = builderCriteria.createQuery(Pessoa.class);
		Root<Pessoa> pessoa = queryCriteria.from(Pessoa.class);
		
		List<Predicate> condicoesWhere = new ArrayList<Predicate>();
		
		if ( BibliotecaFuncoes.isStringValida(pCPF) ) {
			Path<String> atributoCPF = pessoa.get("cpf");
			queryCriteria.where(builderCriteria.equal(atributoCPF, pCPF));
		}
		
		if ( BibliotecaFuncoes.isStringValida(pEndereco) ) {
			Path<String> atributoEndereco = pessoa.get("endereco");
			queryCriteria.where(builderCriteria.equal(atributoEndereco, pEndereco));
		}
		
		if ( BibliotecaFuncoes.isStringValida(pNome) ) {
			Join<Pessoa, DadosPessoais> dadosPessoa = pessoa.join("dadosPessoais");
			queryCriteria.where(
				builderCriteria.and(
					builderCriteria.equal(
						dadosPessoa.get("nome"), pNome
					)
				)
			);
		}
		
		Predicate[] arrayCondicionais =
			condicoesWhere.toArray(new Predicate[condicoesWhere.size()]);
		
		Predicate todosOsCondicionais = 
			builderCriteria.and(arrayCondicionais);
		
		queryCriteria.where(todosOsCondicionais);
		
		TypedQuery<Pessoa> queryPessoa = manager.createQuery(queryCriteria);
		
		Collection<Pessoa> pessoas = queryPessoa.getResultList();
		pessoas.toString();
		
		manager.close();
	}
	
	public void consultarPessoaComCriteriaDoHibernate(
		String pCPF, 
		String pEndereco,
		String pNome,
		String pDtNascimento
	) {
		SessionFactory factory = BibliotecaFuncoes.createSessionHibernate_4_2_21();
		
		Session session = factory.openSession();
		Criteria criteriaHibernate = session.createCriteria(Pessoa.class, "p");
		
		if ( BibliotecaFuncoes.isStringValida(pCPF) ) {
			criteriaHibernate.add(Restrictions.eq("p.cpf", pCPF));
		}
		
		if ( BibliotecaFuncoes.isStringValida(pEndereco) ) {
			criteriaHibernate.add(Restrictions.eq("p.endereco", pEndereco));
		}
		
		boolean isJoinDone = false;
		if ( BibliotecaFuncoes.isStringValida(pNome) ) {
			criteriaHibernate.createAlias("p.dadosPessoais", "dp");
			criteriaHibernate.add(Restrictions.eq("p.cpf", "dp.cpf"));
			criteriaHibernate.add(Restrictions.eq("dp.nome", pNome));
			
			isJoinDone = true;
		}
		
		if ( BibliotecaFuncoes.isStringValida(pDtNascimento) ) {
			if ( !isJoinDone ) {
				criteriaHibernate.createAlias("p.dadosPessoais", "dp", JoinType.INNER_JOIN);
			}
			criteriaHibernate.add(Restrictions.eq("dp.dataNascimento", BibliotecaFuncoes.getData(pDtNascimento)));
		}
		
		Collection<Pessoa> pessoas = criteriaHibernate.list();
		Object pessoa = session.load(Pessoa.class, pCPF);
		
		pessoas.toString();
		pessoa.toString();
		
		session.close();
		factory.close();
	}
	
}