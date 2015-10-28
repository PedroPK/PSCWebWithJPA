package br.unibratec.heranca.main;

import br.unibratec.heranca.mappedsuperclass.entidades.AlunoHerancaMappedSuperclass;
import br.unibratec.heranca.mappedsuperclass.entidades.ProfessorHerancaMappedSuperclass;
import br.unibratec.heranca.mappedsuperclass.persistencia.HerancaMappedSuperclassDAO;
import br.unibratec.heranca.mappedsuperclass.persistencia.IHerancaMappedSuperclassDAO;
import br.unibratec.util.BibliotecaFuncoes;
import br.unibratec.util.ConstantesGerais;
import br.unibratec.util.UtilJPA;


public class SubMainHerancaMappedSuperclass {
	
	public static void main(String[] args) {
		persistirAlunoProfessorHerancaMappedSuperclass();
		//getReferenciaAluno();
		//removerAluno();
		executarQueryJPQL();
	}
	
	public static void executarQueryJPQL() {
		IHerancaMappedSuperclassDAO alunoProfessorHerancaMappedSuperclassDAO = new HerancaMappedSuperclassDAO();
		alunoProfessorHerancaMappedSuperclassDAO.executarQueryJPQL();
	}
	public static void executarQueryJPQL(String pCdAluno) {
		IHerancaMappedSuperclassDAO alunoProfessorHerancaMappedSuperclassDAO = new HerancaMappedSuperclassDAO();
		alunoProfessorHerancaMappedSuperclassDAO.executarQueryJPQL(pCdAluno);
	}
	
	public static void removerAluno() {
		IHerancaMappedSuperclassDAO alunoProfessorHerancaMappedSuperclassDAO = new HerancaMappedSuperclassDAO();
		alunoProfessorHerancaMappedSuperclassDAO.removerAluno(ConstantesGerais.CPF_123_456_789_01);
	}
	
	public static void consultarAluno() {
		IHerancaMappedSuperclassDAO alunoProfessorHerancaMappedSuperclassDAO = new HerancaMappedSuperclassDAO();
		alunoProfessorHerancaMappedSuperclassDAO.consultarAluno(ConstantesGerais.CPF_123_456_789_01);
	}
	
	public static void getReferenciaAluno() {
		IHerancaMappedSuperclassDAO alunoProfessorHerancaMappedSuperclassDAO = new HerancaMappedSuperclassDAO();
		alunoProfessorHerancaMappedSuperclassDAO.getReferenciaAluno(ConstantesGerais.CPF_123_456_789_01);
	}
	
	public static void consultarProfessorHeranca() {
		IHerancaMappedSuperclassDAO alunoProfessorHerancaMappedSuperclassDAO = new HerancaMappedSuperclassDAO();
		alunoProfessorHerancaMappedSuperclassDAO.consultarProfessorHeranca(ConstantesGerais.CPF_123_456_789_01);
	}

	public static void persistirAlunoProfessorHerancaMappedSuperclass() {
		IHerancaMappedSuperclassDAO alunoProfessorHerancaMappedSuperclassDAO = new HerancaMappedSuperclassDAO();
		
		AlunoHerancaMappedSuperclass aluno1 = new AlunoHerancaMappedSuperclass();
		aluno1.setCodigoAluno(ConstantesGerais.CPF_123_456_789_01);
		aluno1.setNome("João Baptisuntum");
		
		AlunoHerancaMappedSuperclass aluno2 = new AlunoHerancaMappedSuperclass();
		aluno2.setCodigoAluno(ConstantesGerais.CPF_987_654_321_09);
		aluno2.setNome("Meu nome não é Johnny");
		
		AlunoHerancaMappedSuperclass aluno3 = new AlunoHerancaMappedSuperclass();
		aluno3.setCodigoAluno(ConstantesGerais.CPF_135_792_468_01);
		aluno3.setNome("Mario, que Mario?");
		
		ProfessorHerancaMappedSuperclass professorHerancaMappedSuperclass1 = new ProfessorHerancaMappedSuperclass();
		professorHerancaMappedSuperclass1.setCodigoProfessor(ConstantesGerais.UM);
		professorHerancaMappedSuperclass1.setNome("Pedro Santos");
		professorHerancaMappedSuperclass1.setDataContratacao(BibliotecaFuncoes.getData("06/08/2015"));
		
		ProfessorHerancaMappedSuperclass ProfessorHerancaMappedSuperclass2 = new ProfessorHerancaMappedSuperclass();
		ProfessorHerancaMappedSuperclass2.setCodigoProfessor(ConstantesGerais.DOIS);
		ProfessorHerancaMappedSuperclass2.setNome("Melo");
		
		ProfessorHerancaMappedSuperclass ProfessorHerancaMappedSuperclass3 = new ProfessorHerancaMappedSuperclass();
		ProfessorHerancaMappedSuperclass3.setCodigoProfessor(ConstantesGerais.TRES);
		ProfessorHerancaMappedSuperclass3.setNome("Fred");
		
		ProfessorHerancaMappedSuperclass ProfessorHerancaMappedSuperclass4 = new ProfessorHerancaMappedSuperclass();
		ProfessorHerancaMappedSuperclass4.setCodigoProfessor(ConstantesGerais.QUATRO);
		ProfessorHerancaMappedSuperclass4.setNome("Eduardo");
		
		alunoProfessorHerancaMappedSuperclassDAO.persistir(aluno1);
		alunoProfessorHerancaMappedSuperclassDAO.persistir(aluno2);
		alunoProfessorHerancaMappedSuperclassDAO.persistir(aluno3);
		alunoProfessorHerancaMappedSuperclassDAO.persistir(professorHerancaMappedSuperclass1);
		alunoProfessorHerancaMappedSuperclassDAO.persistir(ProfessorHerancaMappedSuperclass2);
		alunoProfessorHerancaMappedSuperclassDAO.persistir(ProfessorHerancaMappedSuperclass3);
		alunoProfessorHerancaMappedSuperclassDAO.persistir(ProfessorHerancaMappedSuperclass4);
	}

	public static void atualizarRelacionamentos () {
		IHerancaMappedSuperclassDAO dao = new HerancaMappedSuperclassDAO();
		
		AlunoHerancaMappedSuperclass aluno1 = new AlunoHerancaMappedSuperclass();
		aluno1.setCodigoAluno(ConstantesGerais.CPF_123_456_789_01);
		aluno1 = dao.consultarAluno(aluno1);
		
		AlunoHerancaMappedSuperclass aluno2 = new AlunoHerancaMappedSuperclass();
		aluno2.setCodigoAluno(ConstantesGerais.CPF_987_654_321_09);
		aluno2 = dao.consultarAluno(aluno2);
		
		AlunoHerancaMappedSuperclass aluno3 = new AlunoHerancaMappedSuperclass();
		aluno3.setCodigoAluno(ConstantesGerais.CPF_135_792_468_01);
		aluno3 = dao.consultarAluno(aluno3);
		
		ProfessorHerancaMappedSuperclass ProfessorHerancaMappedSuperclass1 = new ProfessorHerancaMappedSuperclass();
		ProfessorHerancaMappedSuperclass1.setCodigoProfessor(ConstantesGerais.UM);
		ProfessorHerancaMappedSuperclass1 = dao.consultarProfessorHeranca(ProfessorHerancaMappedSuperclass1);
		
		ProfessorHerancaMappedSuperclass ProfessorHerancaMappedSuperclass2 = new ProfessorHerancaMappedSuperclass();
		ProfessorHerancaMappedSuperclass2.setCodigoProfessor(ConstantesGerais.DOIS);
		ProfessorHerancaMappedSuperclass2 = dao.consultarProfessorHeranca(ProfessorHerancaMappedSuperclass2);
		
		ProfessorHerancaMappedSuperclass ProfessorHerancaMappedSuperclass3 = new ProfessorHerancaMappedSuperclass();
		ProfessorHerancaMappedSuperclass3.setCodigoProfessor(ConstantesGerais.TRES);
		ProfessorHerancaMappedSuperclass3 = dao.consultarProfessorHeranca(ProfessorHerancaMappedSuperclass3);
		
		ProfessorHerancaMappedSuperclass ProfessorHerancaMappedSuperclass4 = new ProfessorHerancaMappedSuperclass();
		ProfessorHerancaMappedSuperclass4.setCodigoProfessor(ConstantesGerais.QUATRO);
		ProfessorHerancaMappedSuperclass4 = dao.consultarProfessorHeranca(ProfessorHerancaMappedSuperclass4);
		
		dao.atualizar(aluno1);
		dao.atualizar(aluno2);
		dao.atualizar(aluno3);
		
		dao.atualizar(ProfessorHerancaMappedSuperclass1);
		dao.atualizar(ProfessorHerancaMappedSuperclass2);
		dao.atualizar(ProfessorHerancaMappedSuperclass3);
		dao.atualizar(ProfessorHerancaMappedSuperclass3);
		
		UtilJPA.closeEntityManagerFactory();
	}
	
}
