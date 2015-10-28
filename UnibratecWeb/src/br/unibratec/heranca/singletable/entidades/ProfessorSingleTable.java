package br.unibratec.heranca.singletable.entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PessoaProfessor")
public class ProfessorSingleTable extends PessoaSingleTable {
	
	private Float salario;
	
	public ProfessorSingleTable() {}

	public Float getSalario() {
		return salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}
	
	
}