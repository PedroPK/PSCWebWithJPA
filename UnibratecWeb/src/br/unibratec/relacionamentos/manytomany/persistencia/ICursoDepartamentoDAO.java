package br.unibratec.relacionamentos.manytomany.persistencia;

import br.unibratec.relacionamentos.manytomany.entidades.Curso;
import br.unibratec.relacionamentos.manytomany.entidades.Departamento;

public interface ICursoDepartamentoDAO {
	
	public void persistir( Curso pCurso, Departamento pDepartamento );
	public void persistir( Curso pCurso );
	public void persistir( Departamento pDepartamento );
	
	public void consultarCurso(Curso pCurso);
	public void consultarCurso(String pCdCurso);
	
	public void consultarDepartamento(Departamento pDepartamento);
	public void consultarDepartamento(String pCdDepartamento);
	
}
