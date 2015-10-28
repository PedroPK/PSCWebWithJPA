package br.unibratec.heranca.joined.entidades;

import javax.persistence.Entity;

@Entity
public class ProfessorJoined extends PessoaJoined {
	
	private Float salario;
	
	public ProfessorJoined() {}

	public Float getSalario() {
		return salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}
	
	
}