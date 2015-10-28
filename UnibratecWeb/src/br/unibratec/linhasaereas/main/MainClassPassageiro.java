package br.unibratec.linhasaereas.main;

import br.unibratec.linhasaereas.fachada.FachadaLinhasAereas;
import br.unibratec.linhasaereas.fachada.IFachadaLinhasAereas;
import br.unibratec.util.ConstantesGerais;

public class MainClassPassageiro {
	
	public static void main(String[] args) {
		inserirPassageiro();
		consultarPassageiro();
	}
	
	public static void consultarPassageiro() {
		IFachadaLinhasAereas fachada = new FachadaLinhasAereas();
		fachada.consultarPassageiro(ConstantesGerais.CPF_123_456_789_01);
	}

	private static void inserirPassageiro() {
		IFachadaLinhasAereas fachada = new FachadaLinhasAereas();
		
		fachada.inserirPassageiro(
			"Pedro Santos", 
			ConstantesGerais.CPF_123_456_789_01, 
			"prof.pcfs@gmail.com", 
			"06/08/2015", 
			"false");
	}
	
}
