package br.unibratec.heranca.main;

import br.unibratec.heranca.tableperclass.entidades.AlunoTablePerClass;
import br.unibratec.heranca.tableperclass.entidades.ProfessorTablePerClass;
import br.unibratec.heranca.tableperclass.persistencia.HerancaTablePerClassDAO;
import br.unibratec.heranca.tableperclass.persistencia.IHerancaTablePerClassDAO;
import br.unibratec.util.ConstantesGerais;
import br.unibratec.util.UtilJPA;

public class SubMainHerancaTablePerClass {
	
	public static void main(String[] args) {
		persistirAlunoProfessorHerancaTablePerClass();
	}
	
	public static void consultarAluno() {
		IHerancaTablePerClassDAO alunoProfessorHerancaDAO = new HerancaTablePerClassDAO();
		alunoProfessorHerancaDAO.consultarAluno(ConstantesGerais.CPF_123_456_789_01);
	}
	
	public static void consultarProfessorHeranca() {
		IHerancaTablePerClassDAO alunoProfessorHerancaDAO = new HerancaTablePerClassDAO();
		alunoProfessorHerancaDAO.consultarProfessorHeranca(ConstantesGerais.CPF_123_456_789_01);
	}

	public static void persistirAlunoProfessorHerancaTablePerClass() {
		IHerancaTablePerClassDAO alunoProfessorHerancaDAO = new HerancaTablePerClassDAO();
		
		AlunoTablePerClass aluno1 = new AlunoTablePerClass();
		aluno1.setCodigoPessoa(ConstantesGerais.CPF_123_456_789_01);
		aluno1.setNome("João Baptisuntum");
		aluno1.setIsFies(true);
		
		AlunoTablePerClass aluno2 = new AlunoTablePerClass();
		aluno2.setCodigoPessoa(ConstantesGerais.CPF_987_654_321_09);
		aluno2.setNome("Meu nome não é Johnny");
		aluno2.setIsFies(false);
		
		AlunoTablePerClass aluno3 = new AlunoTablePerClass();
		aluno3.setCodigoPessoa(ConstantesGerais.CPF_135_792_468_01);
		aluno3.setNome("Mario, que Mario?");
		aluno3.setIsFies(true);
		
		ProfessorTablePerClass ProfessorHeranca1 = new ProfessorTablePerClass();
		ProfessorHeranca1.setCodigoPessoa(ConstantesGerais.UM);
		ProfessorHeranca1.setNome("Pedro Santos");
		ProfessorHeranca1.setSalario(750.0f);
		
		ProfessorTablePerClass ProfessorHeranca2 = new ProfessorTablePerClass();
		ProfessorHeranca2.setCodigoPessoa(ConstantesGerais.DOIS);
		ProfessorHeranca2.setNome("Melo");
		ProfessorHeranca2.setSalario(3500.0f);
		
		ProfessorTablePerClass ProfessorHeranca3 = new ProfessorTablePerClass();
		ProfessorHeranca3.setCodigoPessoa(ConstantesGerais.TRES);
		ProfessorHeranca3.setNome("Fred");
		ProfessorHeranca3.setSalario(10000.0f);
		
		ProfessorTablePerClass ProfessorHeranca4 = new ProfessorTablePerClass();
		ProfessorHeranca4.setCodigoPessoa(ConstantesGerais.QUATRO);
		ProfessorHeranca4.setNome("Eduardo");
		ProfessorHeranca4.setSalario(1000.0f);
		
		alunoProfessorHerancaDAO.persistir(aluno1);
		alunoProfessorHerancaDAO.persistir(aluno2);
		alunoProfessorHerancaDAO.persistir(aluno3);
		alunoProfessorHerancaDAO.persistir(ProfessorHeranca1);
		alunoProfessorHerancaDAO.persistir(ProfessorHeranca2);
		alunoProfessorHerancaDAO.persistir(ProfessorHeranca3);
		alunoProfessorHerancaDAO.persistir(ProfessorHeranca4);		
	}
	
	public static void atualizarRelacionamentos () {
		IHerancaTablePerClassDAO dao = new HerancaTablePerClassDAO();
		
		AlunoTablePerClass aluno1 = new AlunoTablePerClass();
		aluno1.setCodigoPessoa(ConstantesGerais.CPF_123_456_789_01);
		aluno1 = dao.consultarAluno(aluno1);
		
		AlunoTablePerClass aluno2 = new AlunoTablePerClass();
		aluno2.setCodigoPessoa(ConstantesGerais.CPF_987_654_321_09);
		aluno2 = dao.consultarAluno(aluno2);
		
		AlunoTablePerClass aluno3 = new AlunoTablePerClass();
		aluno3.setCodigoPessoa(ConstantesGerais.CPF_135_792_468_01);
		aluno3 = dao.consultarAluno(aluno3);
		
		ProfessorTablePerClass ProfessorHeranca1 = new ProfessorTablePerClass();
		ProfessorHeranca1.setCodigoPessoa(ConstantesGerais.UM);
		ProfessorHeranca1 = dao.consultarProfessorHeranca(ProfessorHeranca1);
		
		ProfessorTablePerClass ProfessorHeranca2 = new ProfessorTablePerClass();
		ProfessorHeranca2.setCodigoPessoa(ConstantesGerais.DOIS);
		ProfessorHeranca2 = dao.consultarProfessorHeranca(ProfessorHeranca2);
		
		ProfessorTablePerClass ProfessorHeranca3 = new ProfessorTablePerClass();
		ProfessorHeranca3.setCodigoPessoa(ConstantesGerais.TRES);
		ProfessorHeranca3 = dao.consultarProfessorHeranca(ProfessorHeranca3);
		
		ProfessorTablePerClass ProfessorHeranca4 = new ProfessorTablePerClass();
		ProfessorHeranca4.setCodigoPessoa(ConstantesGerais.QUATRO);
		ProfessorHeranca4 = dao.consultarProfessorHeranca(ProfessorHeranca4);
		
		dao.atualizar(aluno1);
		dao.atualizar(aluno2);
		dao.atualizar(aluno3);
		
		dao.atualizar(ProfessorHeranca1);
		dao.atualizar(ProfessorHeranca2);
		dao.atualizar(ProfessorHeranca3);
		dao.atualizar(ProfessorHeranca3);
		
		UtilJPA.closeEntityManagerFactory();
	}
	
}