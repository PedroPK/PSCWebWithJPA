package br.unibratec.relacionamentos.manytomany.entidades;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="departamento")
public class Departamento {
	@Id
	@Column(name="id_departamento")
	private Integer idDepartamento;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="departamento_curso",
			joinColumns=@JoinColumn(name="id_departamento"),
			inverseJoinColumns=@JoinColumn(name="id_curso")
	)
	private Collection<Curso> cursos;
	
	public Departamento () {}

	public Integer getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public Collection<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Collection<Curso> cursos) {
		this.cursos = cursos;
	}
	
	
}
