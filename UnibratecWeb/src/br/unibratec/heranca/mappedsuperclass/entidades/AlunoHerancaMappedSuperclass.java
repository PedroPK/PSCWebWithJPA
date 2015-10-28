package br.unibratec.heranca.mappedsuperclass.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AlunoHerancaMappedSuperclass extends PessoaHerancaMappedSuperclass {
	@Id
	private String codigoAluno;
	
	private Boolean isFies;
	
	public Boolean getIsFies() {
		return isFies;
	}

	public void setIsFies(Boolean isFies) {
		this.isFies = isFies;
	}

	public AlunoHerancaMappedSuperclass() {}
	
	public String getCodigoAluno() {
		return codigoAluno;
	}

	public void setCodigoAluno(String codigoAluno) {
		this.codigoAluno = codigoAluno;
	}
	
}