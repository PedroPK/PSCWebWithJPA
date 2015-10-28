package br.unibratec.linhasaereas.fachada;

import br.unibratec.linhasaereas.controladores.ControladorPassageiro;
import br.unibratec.linhasaereas.controladores.IControladorPassageiro;
import br.unibratec.linhasaereas.entidades.Passageiro;

public class FachadaLinhasAereas implements IFachadaLinhasAereas {
	
	public void inserirPassageiro(
		String	pNome,
		String	pCPF,
		String	pEMail,
		String	pDataNascimento,
		String	pIsPortadorNecessidadesEspeciais
	)  {
		IControladorPassageiro controladorPassageiro = new ControladorPassageiro();
		controladorPassageiro.inserirPassageiro(pNome, pCPF, pEMail, pDataNascimento, pIsPortadorNecessidadesEspeciais);
	}
	
	public void inserir(Passageiro pPassageiro) {
		IControladorPassageiro controladorPassageiro = new ControladorPassageiro();
		controladorPassageiro.inserir(pPassageiro);
	}

	@Override
	public void consultarPassageiro(Object pChavePrimariaPassageiro) {
		IControladorPassageiro controladorPassageiro = new ControladorPassageiro();
		controladorPassageiro.consultar(pChavePrimariaPassageiro);
	}
	
}
