package br.unibratec.relacionamentos.manytomany.persistencia;

import br.unibratec.relacionamentos.manytomany.entidades.Aluno;
import br.unibratec.relacionamentos.manytomany.entidades.Disciplina;

public interface IAlunoDisciplinaDAO {
	
	public void executarQueryJPQLComJoin();
	public void executarQueryJPQLComColunasExtras();
	public void executarQueryJPQLComColunasExtrasTipada();
	
	public void executarNamedQueryAlunosPSC();
	
	public void executarQueryParametrizada();
	
	public void executarQueryComCache2oNivel();
	
	public void persistir( Aluno pAluno, Disciplina pDisciplina );
	public void persistir( Aluno pAluno );
	public void persistir( Disciplina pDisciplina );
	
	public void atualizar( Aluno pAluno, Disciplina pDisciplina );
	public void atualizar( Aluno pAluno );
	public void atualizar( Disciplina pDisciplina );
	
	public Aluno consultarAluno(Aluno pAluno);
	public Aluno consultarAluno(String pCPF);
	
	public Disciplina consultarDisciplina(Disciplina pDisciplina);
	public Disciplina consultarDisciplina(String pCdDisciplina);
	
}
