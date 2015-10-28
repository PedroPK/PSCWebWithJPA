package br.unibratec.relacionamentos.manytoone.main;

import br.unibratec.relacionamentos.manytoone.entidades.Autor;
import br.unibratec.relacionamentos.manytoone.entidades.Monografia;
import br.unibratec.relacionamentos.manytoone.persistencia.IMonografiaDAO;
import br.unibratec.relacionamentos.manytoone.persistencia.MonografiaDAO;

public class MainRelacionamentosManyToOne {
	
	public static void main(String[] args) {
		consultarMonografia();
	}
	
	private static void consultarMonografia() {
		IMonografiaDAO monografiaDAO = new MonografiaDAO();
		monografiaDAO.consultarMonografia(	Long.valueOf(123456789l)	);
	}
	
	public static void consultarAutor() {
		IMonografiaDAO monografiaDAO = new MonografiaDAO();
		monografiaDAO.consultarAutor("123456");
	}

	public static void persistirAutorMonografia() {
		IMonografiaDAO monografiaDAO = new MonografiaDAO();
		
		Autor autor = new Autor();
		autor.setCodigoAutor("123456");
		
		Monografia monografia = new Monografia();
		monografia.setDoi(1234567890l);
		monografia.setAutor(autor);
		
		monografiaDAO.persistir(monografia, autor);
	}
	
}
