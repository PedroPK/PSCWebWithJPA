package br.unibratec.relacionamentos.manytomany.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Disciplina implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8482771200718422648L;

	@Id
	private String codigo; 
	
	private String descricao; 
	
	@ManyToMany(mappedBy="disciplinasMatriculadas", fetch=FetchType.EAGER)
	private Collection<Aluno> alunosMatriculados;
	
	public Disciplina() {}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Collection<Aluno> getAlunosMatriculados() {
		return alunosMatriculados;
	}

	public void setAlunosMatriculados(Collection<Aluno> alunosMatriculados) {
		this.alunosMatriculados = alunosMatriculados;
	}
	
	public void matricularAluno( Aluno pAluno ) {
		if ( this.alunosMatriculados == null ) {
			this.alunosMatriculados = new HashSet<Aluno>();
		}
		
		this.alunosMatriculados.add(pAluno);
	}
	
}
