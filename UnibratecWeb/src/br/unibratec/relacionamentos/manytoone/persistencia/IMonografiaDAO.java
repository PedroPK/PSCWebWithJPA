package br.unibratec.relacionamentos.manytoone.persistencia;

import br.unibratec.relacionamentos.manytoone.entidades.Autor;
import br.unibratec.relacionamentos.manytoone.entidades.Monografia;

public interface IMonografiaDAO {
	
	public void persistir(Monografia pMonografia, Autor pAutor);
	
	public void persistir(Monografia pMonografia);
	
	public void persistirAutor(Autor pAutor);
	
	public void consultarAutor(Autor pAutor);
	public void consultarAutor(String pCdAutor);
	
	public void consultarMonografia(Monografia pMonografia);
	public void consultarMonografia(Long pCdMonografia);
	
}
