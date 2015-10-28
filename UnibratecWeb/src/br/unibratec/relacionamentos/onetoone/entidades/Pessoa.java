package br.unibratec.relacionamentos.onetoone.entidades;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.SqlResultSetMapping;

@Entity
@NamedNativeQuery(
	name=Pessoa.NM_QUERY_NATIVA,
	query="Select p.*, dp.* From Pessoa p Join DadosPessoais dp On dp.DP_CPF = p.cpf",
	resultSetMapping=Pessoa.NM_RESULTSET_MAPPING
)
@SqlResultSetMapping(
	name=Pessoa.NM_RESULTSET_MAPPING,
	entities={
		@EntityResult(entityClass=Pessoa.class),
		@EntityResult(entityClass=DadosPessoais.class,
			fields={
					@FieldResult(name="cpf", column=DadosPessoais.NM_COLUNA_CPF),
					@FieldResult(name="nome", column="nome"),
					@FieldResult(name="dataNascimento", column="dataNascimento")
				}
		)
	}
)
//@Cacheable
public class Pessoa {
	
	public static final String NM_QUERY_NATIVA = "NM_QUERY_NATIVA";
	public static final String NM_RESULTSET_MAPPING = "NM_RESULTSET_MAPPING"; 
	
	@Id
	private String cpf;
	private String endereco;
	
	@OneToOne
	private DadosPessoais dadosPessoais;
	
	public Pessoa() {}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String pCpf) {
		this.cpf = pCpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String pEndereco) {
		this.endereco = pEndereco;
	}

	public DadosPessoais getDadosPessoais() {
		return dadosPessoais;
	}

	public void setDadosPessoais(DadosPessoais pDadosPessoais) {
		this.dadosPessoais = pDadosPessoais;
		pDadosPessoais.setPessoa(this);
	}
	
	
}
