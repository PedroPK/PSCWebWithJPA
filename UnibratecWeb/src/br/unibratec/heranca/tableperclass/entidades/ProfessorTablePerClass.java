package br.unibratec.heranca.tableperclass.entidades;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class ProfessorTablePerClass extends PessoaTablePerClass {
	
	private Float salario;
	private Date dataContratacao;
	
	public Date getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public ProfessorTablePerClass() {}

	public Float getSalario() {
		return salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}
	
	
}