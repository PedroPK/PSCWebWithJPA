package br.unibratec.heranca.singletable.entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PessoaAluno")
public class AlunoSingleTable extends PessoaSingleTable {
	
	private Boolean isFies;
	
	public AlunoSingleTable() {}

	public Boolean getIsFies() {
		return isFies;
	}

	public void setIsFies(Boolean pIsFies) {
		this.isFies = pIsFies;
	}
	
}