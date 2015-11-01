package br.unibratec.linhasaereas.controladores;

import java.util.Collection;
import java.util.Date;

import br.unibratec.linhasaereas.entidades.Passageiro;
import br.unibratec.linhasaereas.persistencia.IPassageiroDAO;
import br.unibratec.linhasaereas.persistencia.PassageiroDAO;
import br.unibratec.util.BibliotecaFuncoes;

public class ControladorPassageiro implements IControladorPassageiro {
	
	public void inserirPassageiro(
		String	pNome,
		String	pCPF,
		String	pEMail,
		String	pDataNascimento,
		String	pIsPortadorNecessidadesEspeciais
	) {
		boolean isPortadorNecessidadesEspeciais = false;
		if ( 
				BibliotecaFuncoes.isStringValida(pIsPortadorNecessidadesEspeciais)		&&
				pIsPortadorNecessidadesEspeciais.equalsIgnoreCase(Boolean.TRUE.toString())
		) {
			isPortadorNecessidadesEspeciais = true;
		}
		
		Date dtNascimento = null;
		if ( BibliotecaFuncoes.isDataValida(pDataNascimento) ) {
			dtNascimento = BibliotecaFuncoes.getData(pDataNascimento);
		}
		
		Passageiro passageiro = 
			new Passageiro(
					pNome,
					pCPF,
					pEMail,
					dtNascimento,
					isPortadorNecessidadesEspeciais
			);
		
		IPassageiroDAO passageiroDAO = new PassageiroDAO();
		passageiroDAO.inserir(passageiro);
	}
	
	public void inserir(Passageiro pPassageiro) {
		IPassageiroDAO passageiroDAO = new PassageiroDAO();
		passageiroDAO.inserir(pPassageiro);
	}
	
	public Passageiro consultar(Object pChavePrimaria) {
		IPassageiroDAO passageiroDAO = new PassageiroDAO();
		Passageiro registro = passageiroDAO.consultar(pChavePrimaria);
		return registro;
	}
	
	public Collection<Passageiro> consultar() {
		IPassageiroDAO passageiroDAO = new PassageiroDAO();
		return passageiroDAO.consultar();
	}
	
}