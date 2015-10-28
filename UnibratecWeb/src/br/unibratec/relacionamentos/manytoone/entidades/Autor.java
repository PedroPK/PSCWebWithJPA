package br.unibratec.relacionamentos.manytoone.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Autor {
	@Id
	@Column(name="AUTOR_CD")
	private String codigoAutor;
	
	public Autor() {}

	public String getCodigoAutor() {
		return codigoAutor;
	}

	public void setCodigoAutor(String pCodigoAutor) {
		this.codigoAutor = pCodigoAutor;
	}
}
