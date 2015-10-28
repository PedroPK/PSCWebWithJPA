package br.unibratec.heranca.singletable.persistencia;

import br.unibratec.heranca.singletable.entidades.AlunoSingleTable;
import br.unibratec.heranca.singletable.entidades.ProfessorSingleTable;

public interface IHerancaSingleTableDAO {
	
	public void persistir( AlunoSingleTable pAluno, ProfessorSingleTable pDisciplina );
	public void persistir( AlunoSingleTable pAluno );
	public void persistir( ProfessorSingleTable pDisciplina );
	
	public void atualizar( AlunoSingleTable pAluno, ProfessorSingleTable pDisciplina );
	public void atualizar( AlunoSingleTable pAluno );
	public void atualizar( ProfessorSingleTable pDisciplina );
	
	public AlunoSingleTable consultarAluno(AlunoSingleTable pAluno);
	public AlunoSingleTable consultarAluno(String pCPF);
	
	public ProfessorSingleTable consultarProfessorHeranca(ProfessorSingleTable pDisciplina);
	public ProfessorSingleTable consultarProfessorHeranca(String pCdDisciplina);
	
}
