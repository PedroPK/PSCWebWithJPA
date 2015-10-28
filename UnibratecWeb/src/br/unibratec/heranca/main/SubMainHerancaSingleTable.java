package br.unibratec.heranca.main;

import br.unibratec.heranca.singletable.entidades.AlunoSingleTable;
import br.unibratec.heranca.singletable.entidades.ProfessorSingleTable;
import br.unibratec.heranca.singletable.persistencia.HerancaConcretaDAO;
import br.unibratec.heranca.singletable.persistencia.HerancaSingleTableDAO;
import br.unibratec.heranca.singletable.persistencia.IHerancaDAO;
import br.unibratec.heranca.singletable.persistencia.IHerancaSingleTableDAO;
import br.unibratec.util.ConstantesGerais;
import br.unibratec.util.UtilJPA;

public class SubMainHerancaSingleTable {
	
	public static void main(String[] args) {
		persistirAlunoProfessorHeranca();
	}
	
	
	public static void main2(String[] args) {
		inserir();
		
		AlunoSingleTable aluno = consultar();
		
		aluno.setNome("Gilgamesh da Silva");
		alterar(aluno);
		excluirPorObjeto(aluno);
		
		inserir();
		excluirPorChavePrimaria(aluno.getChavePrimaria());
	}
	
	private static AlunoSingleTable consultar() {
		IHerancaDAO dao = new HerancaConcretaDAO();
		AlunoSingleTable aluno = 
			(AlunoSingleTable) dao.consultarPorChavePrimaria(
				AlunoSingleTable.class, 
				ConstantesGerais.CPF_123_456_789_01);
		
		return aluno;
	}
	
	private static void inserir() {
		IHerancaDAO dao = new HerancaConcretaDAO();
		dao.inserir(
			getInstanciaAlunoJoaoSingleTable()
		);
	}
	
	private static void alterar(AlunoSingleTable pAluno) {
		IHerancaDAO dao = new HerancaConcretaDAO();
		dao.alterar(pAluno);
	}
	
	private static void excluirPorObjeto(AlunoSingleTable pAluno) {
		IHerancaDAO dao = new HerancaConcretaDAO();
		dao.excluirPorObjeto(pAluno);
	}
	private static void excluirPorChavePrimaria(Object pChavePrimaria) {
		IHerancaDAO dao = new HerancaConcretaDAO();
		dao.excluirPorChavePrimaria(AlunoSingleTable.class, pChavePrimaria);
	}
	
	public static void consultarAluno() {
		IHerancaSingleTableDAO alunoProfessorHerancaDAO = new HerancaSingleTableDAO();
		alunoProfessorHerancaDAO.consultarAluno(ConstantesGerais.CPF_123_456_789_01);
	}
	
	public static void consultarProfessorHeranca() {
		IHerancaSingleTableDAO alunoProfessorHerancaDAO = new HerancaSingleTableDAO();
		alunoProfessorHerancaDAO.consultarProfessorHeranca(ConstantesGerais.CPF_123_456_789_01);
	}

	private static void persistirAlunoProfessorHeranca() {
		IHerancaSingleTableDAO alunoProfessorHerancaDAO = new HerancaSingleTableDAO();
		
		AlunoSingleTable aluno1 = getInstanciaAlunoJoaoSingleTable();
		
		AlunoSingleTable aluno2 = new AlunoSingleTable();
		aluno2.setCodigoPessoa(ConstantesGerais.CPF_987_654_321_09);
		aluno2.setNome("Meu nome não é Johnny");
		aluno2.setIsFies(false);
		
		AlunoSingleTable aluno3 = new AlunoSingleTable();
		aluno3.setCodigoPessoa(ConstantesGerais.CPF_135_792_468_01);
		aluno3.setNome("Mario, que Mario?");
		aluno3.setIsFies(true);
		
		ProfessorSingleTable ProfessorHeranca1 = new ProfessorSingleTable();
		ProfessorHeranca1.setCodigoPessoa(ConstantesGerais.UM);
		ProfessorHeranca1.setNome("Pedro Santos");
		ProfessorHeranca1.setSalario(750.0f);
		
		ProfessorSingleTable ProfessorHeranca2 = new ProfessorSingleTable();
		ProfessorHeranca2.setCodigoPessoa(ConstantesGerais.DOIS);
		ProfessorHeranca2.setNome("Melo");
		ProfessorHeranca2.setSalario(3500.0f);
		
		ProfessorSingleTable ProfessorHeranca3 = new ProfessorSingleTable();
		ProfessorHeranca3.setCodigoPessoa(ConstantesGerais.TRES);
		ProfessorHeranca3.setNome("Fred");
		ProfessorHeranca3.setSalario(5000.0f);
		
		ProfessorSingleTable ProfessorHeranca4 = new ProfessorSingleTable();
		ProfessorHeranca4.setCodigoPessoa(ConstantesGerais.QUATRO);
		ProfessorHeranca4.setNome("Eduardo");
		ProfessorHeranca4.setSalario(10000.0f);
		
		alunoProfessorHerancaDAO.persistir(aluno1);
		alunoProfessorHerancaDAO.persistir(aluno2);
		alunoProfessorHerancaDAO.persistir(aluno3);
		alunoProfessorHerancaDAO.persistir(ProfessorHeranca1);
		alunoProfessorHerancaDAO.persistir(ProfessorHeranca2);
		alunoProfessorHerancaDAO.persistir(ProfessorHeranca3);
		alunoProfessorHerancaDAO.persistir(ProfessorHeranca4);
	}

	public static AlunoSingleTable getInstanciaAlunoJoaoSingleTable() {
		AlunoSingleTable aluno1 = new AlunoSingleTable();
		aluno1.setCodigoPessoa(ConstantesGerais.CPF_123_456_789_01);
		aluno1.setNome("Joaquim Baptisuntum");
		aluno1.setIsFies(true);
		return aluno1;
	}
	
	public static void atualizarRelacionamentos () {
		IHerancaSingleTableDAO dao = new HerancaSingleTableDAO();
		
		AlunoSingleTable aluno1 = new AlunoSingleTable();
		aluno1.setCodigoPessoa(ConstantesGerais.CPF_123_456_789_01);
		aluno1 = dao.consultarAluno(aluno1);
		
		AlunoSingleTable aluno2 = new AlunoSingleTable();
		aluno2.setCodigoPessoa(ConstantesGerais.CPF_987_654_321_09);
		aluno2 = dao.consultarAluno(aluno2);
		
		AlunoSingleTable aluno3 = new AlunoSingleTable();
		aluno3.setCodigoPessoa(ConstantesGerais.CPF_135_792_468_01);
		aluno3 = dao.consultarAluno(aluno3);
		
		ProfessorSingleTable ProfessorHeranca1 = new ProfessorSingleTable();
		ProfessorHeranca1.setCodigoPessoa(ConstantesGerais.UM);
		ProfessorHeranca1 = dao.consultarProfessorHeranca(ProfessorHeranca1);
		
		ProfessorSingleTable ProfessorHeranca2 = new ProfessorSingleTable();
		ProfessorHeranca2.setCodigoPessoa(ConstantesGerais.DOIS);
		ProfessorHeranca2 = dao.consultarProfessorHeranca(ProfessorHeranca2);
		
		ProfessorSingleTable ProfessorHeranca3 = new ProfessorSingleTable();
		ProfessorHeranca3.setCodigoPessoa(ConstantesGerais.TRES);
		ProfessorHeranca3 = dao.consultarProfessorHeranca(ProfessorHeranca3);
		
		ProfessorSingleTable ProfessorHeranca4 = new ProfessorSingleTable();
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