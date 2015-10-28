package br.unibratec.heranca.main;

import br.unibratec.heranca.joined.entidades.AlunoJoined;
import br.unibratec.heranca.joined.entidades.ProfessorJoined;
import br.unibratec.heranca.joined.persistencia.HerancaJoinedDAO;
import br.unibratec.heranca.joined.persistencia.IHerancaJoinedDAO;
import br.unibratec.util.ConstantesGerais;
import br.unibratec.util.UtilJPA;

public class SubMainHerancaJoined {
	
	public static void main(String[] args) {
		persistirAlunoProfessorHeranca();
	}
	
	public static void executarQueryComJoin() {
		IHerancaJoinedDAO alunoProfessorHerancaDAO = new HerancaJoinedDAO();
		alunoProfessorHerancaDAO.executarQueryComJoin();
	}
	
	public static void consultarAluno() {
		IHerancaJoinedDAO alunoProfessorHerancaDAO = new HerancaJoinedDAO();
		alunoProfessorHerancaDAO.consultarAluno(ConstantesGerais.CPF_123_456_789_01);
	}
	
	public static void consultarProfessorHeranca() {
		IHerancaJoinedDAO alunoProfessorHerancaDAO = new HerancaJoinedDAO();
		alunoProfessorHerancaDAO.consultarProfessorHeranca(ConstantesGerais.CPF_123_456_789_01);
	}

	public static void persistirAlunoProfessorHeranca() {
		IHerancaJoinedDAO alunoProfessorHerancaDAO = new HerancaJoinedDAO();
		
		AlunoJoined aluno1 = new AlunoJoined();
		aluno1.setCodigoPessoa(ConstantesGerais.CPF_123_456_789_01);
		aluno1.setNome("João Baptisuntum");
		aluno1.setIsFies(true);
		
		AlunoJoined aluno2 = new AlunoJoined();
		aluno2.setCodigoPessoa(ConstantesGerais.CPF_987_654_321_09);
		aluno2.setNome("Meu nome não é Johnny");
		aluno2.setIsFies(false);
		
		AlunoJoined aluno3 = new AlunoJoined();
		aluno3.setCodigoPessoa(ConstantesGerais.CPF_135_792_468_01);
		aluno3.setNome("Mario, que Mario?");
		aluno3.setIsFies(true);
		
		ProfessorJoined ProfessorHeranca1 = new ProfessorJoined();
		ProfessorHeranca1.setCodigoPessoa(ConstantesGerais.UM);
		ProfessorHeranca1.setNome("Pedro Santos");
		ProfessorHeranca1.setSalario(750.0f);
		
		ProfessorJoined ProfessorHeranca2 = new ProfessorJoined();
		ProfessorHeranca2.setCodigoPessoa(ConstantesGerais.DOIS);
		ProfessorHeranca2.setNome("Melo");
		ProfessorHeranca2.setSalario(3500.0f);
		
		ProfessorJoined ProfessorHeranca3 = new ProfessorJoined();
		ProfessorHeranca3.setCodigoPessoa(ConstantesGerais.TRES);
		ProfessorHeranca3.setNome("Fred");
		ProfessorHeranca3.setSalario(10000.0f);
		
		ProfessorJoined ProfessorHeranca4 = new ProfessorJoined();
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
		IHerancaJoinedDAO dao = new HerancaJoinedDAO();
		
		AlunoJoined aluno1 = new AlunoJoined();
		aluno1.setCodigoPessoa(ConstantesGerais.CPF_123_456_789_01);
		aluno1 = dao.consultarAluno(aluno1);
		
		AlunoJoined aluno2 = new AlunoJoined();
		aluno2.setCodigoPessoa(ConstantesGerais.CPF_987_654_321_09);
		aluno2 = dao.consultarAluno(aluno2);
		
		AlunoJoined aluno3 = new AlunoJoined();
		aluno3.setCodigoPessoa(ConstantesGerais.CPF_135_792_468_01);
		aluno3 = dao.consultarAluno(aluno3);
		
		ProfessorJoined ProfessorHeranca1 = new ProfessorJoined();
		ProfessorHeranca1.setCodigoPessoa(ConstantesGerais.UM);
		ProfessorHeranca1 = dao.consultarProfessorHeranca(ProfessorHeranca1);
		
		ProfessorJoined ProfessorHeranca2 = new ProfessorJoined();
		ProfessorHeranca2.setCodigoPessoa(ConstantesGerais.DOIS);
		ProfessorHeranca2 = dao.consultarProfessorHeranca(ProfessorHeranca2);
		
		ProfessorJoined ProfessorHeranca3 = new ProfessorJoined();
		ProfessorHeranca3.setCodigoPessoa(ConstantesGerais.TRES);
		ProfessorHeranca3 = dao.consultarProfessorHeranca(ProfessorHeranca3);
		
		ProfessorJoined ProfessorHeranca4 = new ProfessorJoined();
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