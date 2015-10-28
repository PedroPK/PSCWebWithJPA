package br.unibratec.relacionamentos.onetoone.main;

import java.time.Instant;
import java.util.Date;

import br.unibratec.relacionamentos.onetoone.entidades.DadosPessoais;
import br.unibratec.relacionamentos.onetoone.entidades.Pessoa;
import br.unibratec.relacionamentos.onetoone.persistencia.IPessoaDAO;
import br.unibratec.relacionamentos.onetoone.persistencia.PessoaDAO;
import br.unibratec.util.ConstantesGerais;
import br.unibratec.util.UtilJPA;

public class MainRelacionamentosOneToOne {
	
	public static void main(String[] args) {
		persistirPessoaDadosPessoais();
		consultarPessoaComCriteriaDoHibernate();
		
		UtilJPA.closeEntityManagerFactory();
	}
	
	private static void consultarPessoaComCriteriaDoHibernate() {
		IPessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.consultarPessoaComCriteriaDoHibernate(
			ConstantesGerais.CPF_123_456_789_01, 
			ConstantesGerais.RUA_FLORIANO_PEIXOTO_780, 
			ConstantesGerais.JOAO_BAPTISUNTUM, 
			"06/08/2015"
		);
				
	}
	
	public static void consultarPessoaComCriteria() {
		IPessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.consultarPessoaComCriteria(
			ConstantesGerais.CPF_123_456_789_01, 
			ConstantesGerais.RUA_FLORIANO_PEIXOTO_780, 
			ConstantesGerais.JOAO_BAPTISUNTUM, 
			null//"06/08/2015"
		);
				
	}
	
	public static void consultarPessoaParametrizando() {
		IPessoaDAO pessoaDAO = new PessoaDAO();
		
		pessoaDAO.consultarPessoaParametrizando(
			ConstantesGerais.CPF_123_456_789_01, 
			null,//ConstantesGerais.RUA_FLORIANO_PEIXOTO_780, 
			null,//ConstantesGerais.JOAO_BAPTISUNTUM, 
			null//"06/08/2015"
		 );
	}
	
	public static void consultarNamedNativeQueryComMapeamento() {
		IPessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.consultarNamedNativeQueryComMapeamento();
	}
	
	public static void consultarDadosPessoais() {
		IPessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.consultarDadosPessoais(ConstantesGerais.CPF_123_456_789_01);
	}
	
	public static void consultarPessoa() {
		IPessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.consultarPessoa(ConstantesGerais.CPF_123_456_789_01);
	}

	private static void persistirPessoaDadosPessoais() {
		IPessoaDAO pessoaDAO = new PessoaDAO();
		
		DadosPessoais dp = new DadosPessoais();
		dp.setCpf(ConstantesGerais.CPF_123_456_789_01);
		dp.setNome(ConstantesGerais.JOAO_BAPTISUNTUM);
		dp.setDataNascimento(Date.from(Instant.now()));
		
		Pessoa p = new Pessoa();
		p.setCpf(ConstantesGerais.CPF_123_456_789_01);
		p.setEndereco(ConstantesGerais.RUA_FLORIANO_PEIXOTO_780);
		p.setDadosPessoais(dp);
		
		pessoaDAO.persistir(p, dp);
	}
	
}
