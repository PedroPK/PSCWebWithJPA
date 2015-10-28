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
@Table(name="curso")
public class Curso {
	
	@Id
	@Column(name="id_curso")
	private Integer idCurso;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="departamento_curso",
			joinColumns=@JoinColumn(name="id_curso"),
			inverseJoinColumns=@JoinColumn(name="id_departamento")
	)
	private Collection<Departamento> departamentos;
	
	public Curso() {}

	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public Collection<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(Collection<Departamento> departamentos) {
		this.departamentos = departamentos;
	}
	
}