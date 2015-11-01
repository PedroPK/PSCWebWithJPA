package br.unibratec.linhasaereas.controladores;

import java.util.Collection;

import br.unibratec.linhasaereas.entidades.Passageiro;

public interface IControladorPassageiro {
	
	public void inserirPassageiro(
		String	pNome,
		String	pCPF,
		String	pEMail,
		String	pDataNascimento,
		String	pIsPortadorNecessidadesEspeciais
	);
	
	public void inserir(Passageiro pPassageiro);
	public Passageiro consultar(Object pChavePrimaria);
	
	public Collection<Passageiro> consultar();
	
}
