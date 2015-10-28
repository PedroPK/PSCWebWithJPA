package br.unibratec.relacionamentos.manytomany.entidades;

public class AlunoQtDisciplinas {
	
	private Aluno aAluno;
	private Integer aQtDisciplinas;
	
	public AlunoQtDisciplinas() {}	
	public AlunoQtDisciplinas(Aluno aAluno, Integer aQtDisciplinas) {
		this.aAluno = aAluno;
		this.aQtDisciplinas = aQtDisciplinas;
	}

	public Aluno getaAluno() {
		return aAluno;
	}
	public void setaAluno(Aluno aAluno) {
		this.aAluno = aAluno;
	}
	public Integer getaQtDisciplinas() {
		return aQtDisciplinas;
	}
	public void setaQtDisciplinas(Integer aQtDisciplinas) {
		this.aQtDisciplinas = aQtDisciplinas;
	}
	
}
