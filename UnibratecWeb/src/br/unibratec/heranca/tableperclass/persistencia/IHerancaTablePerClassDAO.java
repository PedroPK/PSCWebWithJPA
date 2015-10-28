package br.unibratec.heranca.tableperclass.persistencia;

import br.unibratec.heranca.tableperclass.entidades.AlunoTablePerClass;
import br.unibratec.heranca.tableperclass.entidades.ProfessorTablePerClass;

public interface IHerancaTablePerClassDAO {
	
	public void persistir( AlunoTablePerClass pAluno, ProfessorTablePerClass pDisciplina );
	public void persistir( AlunoTablePerClass pAluno );
	public void persistir( ProfessorTablePerClass pDisciplina );
	
	public void atualizar( AlunoTablePerClass pAluno, ProfessorTablePerClass pDisciplina );
	public void atualizar( AlunoTablePerClass pAluno );
	public void atualizar( ProfessorTablePerClass pDisciplina );
	
	public AlunoTablePerClass consultarAluno(AlunoTablePerClass pAluno);
	public AlunoTablePerClass consultarAluno(String pCPF);
	
	public ProfessorTablePerClass consultarProfessorHeranca(ProfessorTablePerClass pDisciplina);
	public ProfessorTablePerClass consultarProfessorHeranca(String pCdDisciplina);
	
}
