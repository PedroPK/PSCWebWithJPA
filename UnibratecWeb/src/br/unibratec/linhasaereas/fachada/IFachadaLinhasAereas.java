package br.unibratec.linhasaereas.fachada;

import br.unibratec.linhasaereas.entidades.Passageiro;

public interface IFachadaLinhasAereas {

	public void inserirPassageiro(
		String	pNome,
		String	pCPF,
		String	pEMail,
		String	pData,
		String	pIsPortadorNecessidadesEspeciais
	);
	
	public void inserir(Passageiro pPassageiro);
	public void consultarPassageiro(Object pChavePrimariaPassageiro);
	
}
