package br.unibratec.heranca.mappedsuperclass.entidades;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class PessoaHerancaMappedSuperclass {
	
	private String nome;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}