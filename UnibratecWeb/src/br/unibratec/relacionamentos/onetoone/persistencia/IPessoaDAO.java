package br.unibratec.relacionamentos.onetoone.persistencia;

import br.unibratec.relacionamentos.onetoone.entidades.DadosPessoais;
import br.unibratec.relacionamentos.onetoone.entidades.Pessoa;

public interface IPessoaDAO {
	
	public void persistir(Pessoa pPessoa, DadosPessoais pDadosPessoais);
	
	public void persistirPessoa(Pessoa pPessoa);
	
	public void persistirDadosPessoais(DadosPessoais pDadosPessoais);
	
	public void consultarDadosPessoais(DadosPessoais pDadosPessoais);
	
	public void consultarDadosPessoais(String pCPF);
	
	public void consultarPessoa(Pessoa pPessoa);
	
	public void consultarPessoa(String pCPF);
	
	public void consultarNamedNativeQueryComMapeamento();
	
	public void consultarPessoaParametrizando(
		String pCPF, 
		String pEndereco,
		String pNome,
		String pDtNascimento
	);
	
	public void consultarPessoaComCriteria(
		String pCPF, 
		String pEndereco,
		String pNome,
		String pDtNascimento
	);
	
	public void consultarPessoaComCriteriaDoHibernate(
			String pCPF, 
			String pEndereco,
			String pNome,
			String pDtNascimento
		);
	
}
