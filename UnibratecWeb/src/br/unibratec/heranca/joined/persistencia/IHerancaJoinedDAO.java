package br.unibratec.heranca.joined.persistencia;

import br.unibratec.heranca.joined.entidades.AlunoJoined;
import br.unibratec.heranca.joined.entidades.ProfessorJoined;

public interface IHerancaJoinedDAO {
	
	public void executarQueryComJoin();
	
	public void persistir( AlunoJoined pAluno, ProfessorJoined pDisciplina );
	public void persistir( AlunoJoined pAluno );
	public void persistir( ProfessorJoined pDisciplina );
	
	public void atualizar( AlunoJoined pAluno, ProfessorJoined pDisciplina );
	public void atualizar( AlunoJoined pAluno );
	public void atualizar( ProfessorJoined pDisciplina );
	
	public AlunoJoined consultarAluno(AlunoJoined pAluno);
	public AlunoJoined consultarAluno(String pCPF);
	
	public ProfessorJoined consultarProfessorHeranca(ProfessorJoined pDisciplina);
	public ProfessorJoined consultarProfessorHeranca(String pCdDisciplina);
	
}
