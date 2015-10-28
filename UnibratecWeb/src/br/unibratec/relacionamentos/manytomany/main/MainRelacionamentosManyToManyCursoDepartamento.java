package br.unibratec.relacionamentos.manytomany.main;

import br.unibratec.relacionamentos.manytomany.entidades.Curso;
import br.unibratec.relacionamentos.manytomany.entidades.Departamento;
import br.unibratec.relacionamentos.manytomany.persistencia.CursoDepartamentoDAO;
import br.unibratec.relacionamentos.manytomany.persistencia.ICursoDepartamentoDAO;


public class MainRelacionamentosManyToManyCursoDepartamento {
	
	public static void main(String[] args) {
		persistirCursoDepartamento();
	}
	
	private static void persistirCursoDepartamento() {
		ICursoDepartamentoDAO dao = new CursoDepartamentoDAO();
		
		Curso c = new Curso();
		c.setIdCurso(Integer.valueOf(1));
		
		Departamento d = new Departamento();
		d.setIdDepartamento(Integer.valueOf(101));
		
		
		dao.persistir(c, d);
	}
	
}
