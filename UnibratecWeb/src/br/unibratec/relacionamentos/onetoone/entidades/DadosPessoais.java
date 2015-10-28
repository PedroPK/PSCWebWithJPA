package br.unibratec.relacionamentos.onetoone.entidades;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class DadosPessoais {
	
	public static final String NM_COLUNA_CPF = "DP_CPF";
	
	@Id
	@Column(name=DadosPessoais.NM_COLUNA_CPF)
	private String cpf;
	
	private String nome;
	private Date dataNascimento;
	
	@OneToOne(mappedBy="dadosPessoais", cascade=CascadeType.ALL)
	@Fetch(value=FetchMode.SELECT)
	private Pessoa pessoa;
	
	public DadosPessoais() {}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String pCpf) {
		this.cpf = pCpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String pNome) {
		this.nome = pNome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date pDataNascimento) {
		this.dataNascimento = pDataNascimento;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pPessoa) {
		this.pessoa = pPessoa;
	}
	
}
