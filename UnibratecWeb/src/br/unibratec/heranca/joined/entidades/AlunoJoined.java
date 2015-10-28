package br.unibratec.heranca.joined.entidades;

import javax.persistence.Entity;

@Entity
public class AlunoJoined extends PessoaJoined {
	
	private Boolean isFies;
	// Etc ...
	
	public AlunoJoined() {}

	public Boolean getIsFies() {
		return isFies;
	}

	public void setIsFies(Boolean isFies) {
		this.isFies = isFies;
	}
	
}