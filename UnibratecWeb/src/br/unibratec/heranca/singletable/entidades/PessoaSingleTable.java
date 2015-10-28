package br.unibratec.heranca.singletable.entidades;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import br.unibratec.entidades.Entidade;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo_classe_entidade")
public abstract class PessoaSingleTable implements Entidade {
	@Id
	private String codigoPessoa;
	
	private String nome;
	
	public Object getChavePrimaria() {
		return getCodigoPessoa();
	}

	public String getCodigoPessoa() {
		return codigoPessoa;
	}

	public void setCodigoPessoa(String pCodigoPessoa) {
		this.codigoPessoa = pCodigoPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String pNome) {
		this.nome = pNome;
	}
	
}