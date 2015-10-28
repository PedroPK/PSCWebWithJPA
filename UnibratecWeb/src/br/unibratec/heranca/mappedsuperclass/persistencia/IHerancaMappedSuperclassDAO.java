package br.unibratec.heranca.mappedsuperclass.persistencia;

import br.unibratec.heranca.mappedsuperclass.entidades.AlunoHerancaMappedSuperclass;
import br.unibratec.heranca.mappedsuperclass.entidades.ProfessorHerancaMappedSuperclass;

public interface IHerancaMappedSuperclassDAO {
	
	public void executarQueryJPQL();
	public void executarQueryJPQL(String pCdAluno);
	
	public void persistir( AlunoHerancaMappedSuperclass pAluno, ProfessorHerancaMappedSuperclass pDisciplina );
	public void persistir( AlunoHerancaMappedSuperclass pAluno );
	public void persistir( ProfessorHerancaMappedSuperclass pDisciplina );
	
	public void atualizar( AlunoHerancaMappedSuperclass pAluno, ProfessorHerancaMappedSuperclass pDisciplina );
	public void atualizar( AlunoHerancaMappedSuperclass pAluno );
	public void atualizar( ProfessorHerancaMappedSuperclass pDisciplina );
	
	public void removerAluno( String pCPFAluno );
	
	public AlunoHerancaMappedSuperclass consultarAluno(AlunoHerancaMappedSuperclass pAluno);
	public AlunoHerancaMappedSuperclass consultarAluno(String pCPF);
	
	public AlunoHerancaMappedSuperclass getReferenciaAluno(String pCPF);
	
	public ProfessorHerancaMappedSuperclass consultarProfessorHeranca(ProfessorHerancaMappedSuperclass pDisciplina);
	public ProfessorHerancaMappedSuperclass consultarProfessorHeranca(String pCdDisciplina);
	
}
