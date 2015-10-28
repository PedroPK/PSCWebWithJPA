package br.unibratec.heranca.main;

import br.unibratec.util.UtilJPA;

public class MainHeranca {
	
	public static void main(String[] args) {
		// Invocar metodo Main de alguma classe SubMain;
		SubMainAbstractDAO.main(args);
		
		
		UtilJPA.closeEntityManagerFactory();
	}
	
}