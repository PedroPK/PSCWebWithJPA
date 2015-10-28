package br.unibratec.linhasaereas.persistencia;

import br.unibratec.linhasaereas.entidades.Passageiro;
import br.unibratec.persistencia.InterfaceDAO;

public interface IPassageiroDAO extends InterfaceDAO {
	
	public Passageiro consultar(Object pChavePrimaria);
}