package br.unibratec.relacionamentos.manytomany.main;

import br.unibratec.relacionamentos.manytomany.entidades.Aluno;
import br.unibratec.relacionamentos.manytomany.entidades.Disciplina;
import br.unibratec.relacionamentos.manytomany.persistencia.AlunoDisciplinaDAO;
import br.unibratec.relacionamentos.manytomany.persistencia.IAlunoDisciplinaDAO;
import br.unibratec.util.ConstantesGerais;
import br.unibratec.util.UtilJPA;


public class MainRelacionamentosManyToMany {
	
	public static void main(String[] args) {
		persistirAlunoDisciplina();
		atualizarRelacionamentos();
		executarQueryComCache2oNivel();
		
		UtilJPA.closeEntityManagerFactory();
	}
	
	private static void executarQueryComCache2oNivel() {
		IAlunoDisciplinaDAO dao = new AlunoDisciplinaDAO();
		dao.executarQueryComCache2oNivel();
	}
	
	public static void executarQueryParametrizada() {
		IAlunoDisciplinaDAO alunoDisciplinaDAO = new AlunoDisciplinaDAO();
		alunoDisciplinaDAO.executarQueryParametrizada();
	}
	
	public static void executarNamedQueryAlunosPSC() {
		IAlunoDisciplinaDAO alunoDisciplinaDAO = new AlunoDisciplinaDAO();
		alunoDisciplinaDAO.executarNamedQueryAlunosPSC();
	}
	
	public static void executarQueryJPQLComColunasExtrasTipada() {
		IAlunoDisciplinaDAO alunoDisciplinaDAO = new AlunoDisciplinaDAO();
		alunoDisciplinaDAO.executarQueryJPQLComColunasExtrasTipada();
	}
	
	public static void executarQueryJPQLComColunasExtras() {
		IAlunoDisciplinaDAO alunoDisciplinaDAO = new AlunoDisciplinaDAO();
		alunoDisciplinaDAO.executarQueryJPQLComColunasExtras();
	}
	
	public static void executarQueryJPQLComJoin() {
		IAlunoDisciplinaDAO alunoDisciplinaDAO = new AlunoDisciplinaDAO();
		alunoDisciplinaDAO.executarQueryJPQLComJoin();
	}
	
	public static void consultarAluno() {
		IAlunoDisciplinaDAO alunoDisciplinaDAO = new AlunoDisciplinaDAO();
		alunoDisciplinaDAO.consultarAluno(ConstantesGerais.CPF_123_456_789_01);
	}
	
	public static void consultarDisciplina() {
		IAlunoDisciplinaDAO alunoDisciplinaDAO = new AlunoDisciplinaDAO();
		alunoDisciplinaDAO.consultarDisciplina(ConstantesGerais.CPF_123_456_789_01);
	}

	private static void persistirAlunoDisciplina() {
		IAlunoDisciplinaDAO alunoDisciplinaDAO = new AlunoDisciplinaDAO();
		
		Aluno aluno1 = new Aluno();
		aluno1.setCpf(ConstantesGerais.CPF_123_456_789_01);
		aluno1.setNome("João Baptisuntum");
		
		Aluno aluno2 = new Aluno();
		aluno2.setCpf("987.654.321-09");
		aluno2.setNome("Meu nome não é Johnny");
		
		Aluno aluno3 = new Aluno();
		aluno3.setCpf("135.792.468-05");
		aluno3.setNome("Mário, que Mário?");
		
		Disciplina disciplina1 = new Disciplina();
		disciplina1.setCodigo("1");
		disciplina1.setDescricao("PSC");
		
		Disciplina disciplina2 = new Disciplina();
		disciplina2.setCodigo("2");
		disciplina2.setDescricao("APS");
		
		Disciplina disciplina3 = new Disciplina();
		disciplina3.setCodigo("3");
		disciplina3.setDescricao("BD");
		
		Disciplina disciplina4 = new Disciplina();
		disciplina4.setCodigo("4");
		disciplina4.setDescricao("CG");
		
		alunoDisciplinaDAO.persistir(aluno1);
		alunoDisciplinaDAO.persistir(aluno2);
		alunoDisciplinaDAO.persistir(aluno3);
		alunoDisciplinaDAO.persistir(disciplina1);
		alunoDisciplinaDAO.persistir(disciplina2);
		alunoDisciplinaDAO.persistir(disciplina3);
		alunoDisciplinaDAO.persistir(disciplina4);
	}
	
	public static void atualizarRelacionamentos () {
		IAlunoDisciplinaDAO dao = new AlunoDisciplinaDAO();
		
		Aluno aluno1 = new Aluno();
		aluno1.setCpf(ConstantesGerais.CPF_123_456_789_01);
		aluno1 = dao.consultarAluno(aluno1);
		
		Aluno aluno2 = new Aluno();
		aluno2.setCpf("987.654.321-09");
		aluno2 = dao.consultarAluno(aluno2);
		
		Aluno aluno3 = new Aluno();
		aluno3.setCpf("135.792.468-05");
		aluno3 = dao.consultarAluno(aluno3);
		
		Disciplina disciplina1PSC = new Disciplina();
		disciplina1PSC.setCodigo("1");
		disciplina1PSC = dao.consultarDisciplina(disciplina1PSC);
		
		Disciplina disciplina2 = new Disciplina();
		disciplina2.setCodigo("2");
		disciplina2 = dao.consultarDisciplina(disciplina2);
		
		Disciplina disciplina3 = new Disciplina();
		disciplina3.setCodigo("3");
		disciplina3 = dao.consultarDisciplina(disciplina3);
		
		Disciplina disciplina4 = new Disciplina();
		disciplina4.setCodigo("4");
		disciplina4 = dao.consultarDisciplina(disciplina4);
		
		aluno1.adicionarDisciplina(disciplina1PSC);
		aluno1.adicionarDisciplina(disciplina2);
		
		aluno2.adicionarDisciplina(disciplina1PSC);
		aluno2.adicionarDisciplina(disciplina2);
		aluno2.adicionarDisciplina(disciplina3);
		
		aluno3.adicionarDisciplina(disciplina1PSC);
		aluno3.adicionarDisciplina(disciplina3);
		aluno3.adicionarDisciplina(disciplina4);
		
		dao.atualizar(aluno1);
		dao.atualizar(aluno2);
		dao.atualizar(aluno3);
		
		dao.atualizar(disciplina1PSC);
		dao.atualizar(disciplina2);
		dao.atualizar(disciplina3);
		dao.atualizar(disciplina3);
	}
	
}