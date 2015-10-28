package br.unibratec.relacionamentos.manytoone.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Monografia {
	@Id
	@Column(name="MONOGRAFIA_CD")
	private Long doi;
	
	@ManyToOne
	@JoinColumn(
		name="MONOGRAFIA_AUTOR_CD",
		referencedColumnName="AUTOR_CD"
	)
	@Fetch(value=FetchMode.SELECT)
	private Autor autor;
	
	public Monografia() {}

	public Long getDoi() {
		return doi;
	}

	public void setDoi(Long pDoi) {
		this.doi = pDoi;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor pAutor) {
		this.autor = pAutor;
	}
	
	
	
}
