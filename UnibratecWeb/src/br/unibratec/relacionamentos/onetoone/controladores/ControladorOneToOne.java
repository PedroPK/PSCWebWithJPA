package br.unibratec.relacionamentos.onetoone.controladores;

import br.unibratec.relacionamentos.onetoone.entidades.DadosPessoais;
import br.unibratec.relacionamentos.onetoone.entidades.Pessoa;
import br.unibratec.relacionamentos.onetoone.persistencia.IPessoaDAO;
import br.unibratec.relacionamentos.onetoone.persistencia.PessoaDAO;
import br.unibratec.util.BibliotecaFuncoes;

public class ControladorOneToOne implements IControladorOneToOne {
	
	public void persistir(String pCPF, String pEndereco, String pNome, String pDtNascimento) {
		Pessoa p = null;
		if ( BibliotecaFuncoes.isStringValida(pCPF)		&&
			 BibliotecaFuncoes.isStringValida(pEndereco)
		) {
			p = new Pessoa();
			p.setCpf(pCPF);
			p.setEndereco(pEndereco);
		}
		
		DadosPessoais dp = null;
		if ( BibliotecaFuncoes.isStringValida(pCPF)		&&
			 BibliotecaFuncoes.isDataValida(pDtNascimento)
		) {
			 dp = new DadosPessoais();
			dp.setCpf(pCPF);
			dp.setDataNascimento(BibliotecaFuncoes.getData(pDtNascimento));
		}
		
		IPessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.persistir(p, dp);
	}
	
	/*public void persistirPessoa(String pCPF, String pEndereco);
	
	public void persistirDadosPessoais(String pCPF, String pNome, String pDtNascimento);
	
	public void consultarDadosPessoais(String pCPF, String pNome, String pDtNascimento);
	
	public void consultarDadosPessoais(String pCPF);
	
	public void consultarPessoa(String pCPF, String pEndereco);
	
	public void consultarPessoa(String pCPF);
	
	public void consultarNamedNativeQueryComMapeamento();
	
	public void consultarPessoaParametrizando(String pCPF, String pEndereco, String pNome, String pDtNascimento);
	
	public void consultarPessoaComCriteria(String pCPF, String pEndereco, String pNome, String pDtNascimento);
	
	public void consultarPessoaComCriteriaDoHibernate(String pCPF, String pEndereco, String pNome,
			String pDtNascimento);
*/			
}