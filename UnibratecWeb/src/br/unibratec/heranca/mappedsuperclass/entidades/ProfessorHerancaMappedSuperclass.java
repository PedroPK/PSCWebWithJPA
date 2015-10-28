package br.unibratec.heranca.mappedsuperclass.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProfessorHerancaMappedSuperclass extends PessoaHerancaMappedSuperclass {
	
	@Id
	private String codigoProfessor;
	
	private Float salario;
	private Date dataContratacao;
	
	public ProfessorHerancaMappedSuperclass() {}
	
	public String getCodigoProfessor() {
		return codigoProfessor;
	}
	public void setCodigoProfessor(String codigoProfessor) {
		this.codigoProfessor = codigoProfessor;
	}
	public Float getSalario() {
		return salario;
	}
	public void setSalario(Float salario) {
		this.salario = salario;
	}
	public Date getDataContratacao() {
		return dataContratacao;
	}
	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}
	
	
}