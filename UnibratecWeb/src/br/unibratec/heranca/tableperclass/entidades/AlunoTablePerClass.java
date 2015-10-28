package br.unibratec.heranca.tableperclass.entidades;

import javax.persistence.Entity;

@Entity
public class AlunoTablePerClass extends PessoaTablePerClass {
	
	private Boolean isFies;
	// Etc ...
	
	public AlunoTablePerClass() {}

	public Boolean getIsFies() {
		return isFies;
	}

	public void setIsFies(Boolean isFies) {
		this.isFies = isFies;
	}
	
}