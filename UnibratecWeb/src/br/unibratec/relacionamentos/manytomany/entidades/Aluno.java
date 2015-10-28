package br.unibratec.relacionamentos.manytomany.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(
	name=Aluno.CONSULTA_ALUNOS_PSC, 
	query="Select a From Aluno a Join a.disciplinasMatriculadas d Where d.descricao Like 'PSC%'"
	/*,
	hints= {
		@QueryHint(
			name=ConstantesGerais.ORG_HIBERNATE_CACHEABLE,
			value=ConstantesGerais.TRUE_STRING
		),
		@QueryHint(
			name=ConstantesGerais.ORG_HIBERNATE_CACHE_REGION,
			value=Aluno.ALUNO_REGIAO_CACHE_CONSULTA_PSC
		)
	}*/
)
@Cacheable
public class Aluno implements Serializable {
	
	public static final String ALUNO_REGIAO_CACHE_CONSULTA_PSC = "Aluno.REGIAO_CACHE_CONSULTA_PSC";
	public static final String CONSULTA_ALUNOS_PSC = "CONSULTA_ALUNOS_PSC";
	
	@Id
	@Column(name="ALUNO_CPF")
	private String cpf;
	private String nome;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="ALUNO_DISCIPLINA",
		joinColumns=@JoinColumn(name="ALUNO_CPF"),
		inverseJoinColumns=@JoinColumn(name="DISCIPLINA_CD")
	)
	private Collection<Disciplina> disciplinasMatriculadas;
	
	// Versão Serial da classe Aluno 
	private static final long serialVersionUID = 6118010509967741189L;
	
	public Aluno() {}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Collection<Disciplina> getDisciplinasMatriculadas() {
		return disciplinasMatriculadas;
	}

	public void setDisciplinasMatriculadas(Collection<Disciplina> disciplinasMatriculadas) {
		this.disciplinasMatriculadas = disciplinasMatriculadas;
	}
	
	public void adicionarDisciplina( Disciplina pDisciplina ) {
		if ( this.disciplinasMatriculadas == null ) {
			this.disciplinasMatriculadas = new HashSet<Disciplina>();
		}
		this.disciplinasMatriculadas.add(pDisciplina);
		pDisciplina.matricularAluno(this);
	}
	
	
}