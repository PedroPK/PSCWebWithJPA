package br.unibratec.heranca.main;

import javax.persistence.EntityManager;

import br.unibratec.entidades.Entidade;
import br.unibratec.heranca.singletable.entidades.AlunoSingleTable;
import br.unibratec.persistencia.DAOConcreto;
import br.unibratec.persistencia.InterfaceDAO;
import br.unibratec.util.ConstantesGerais;
import br.unibratec.util.UtilJPA;

public class SubMainAbstractDAO {
	
	public static void main(String[] args) {
		EntityManager em = UtilJPA.getEntityManager();
		InterfaceDAO dao = new DAOConcreto();
		
		inserir();
		
		Entidade entidade = 
				dao.consultarPorObjeto(
					SubMainHerancaSingleTable.getInstanciaAlunoJoaoSingleTable()
			);
		
		entidade = 
			dao.consultarPorChavePrimaria(
				AlunoSingleTable.class, 
				ConstantesGerais.CPF_123_456_789_01, 
				em, 
				false);
		
		dao.excluirPorObjetoSemConsultarAntes(entidade, em, true);
		
	}

	public static void incluirConsultarAlterarExcluir() {
		inserir();
		Entidade registro = consultar();
		
		alterar( registro );
		excluirPorChavePrimaria( 
			registro.getChavePrimaria() 
		);
	}
	
	private static Entidade consultar() {
		InterfaceDAO dao = new DAOConcreto();
		
					// Tipo escolhido aleatoriamente
		return dao.consultarPorChavePrimaria(AlunoSingleTable.class, ConstantesGerais.CPF_123_456_789_01);
	}
	
	public static Entidade consultar(EntityManager pEntityManager) {
		InterfaceDAO dao = new DAOConcreto();
		
					// Tipo escolhido aleatoriamente
		return dao.consultarPorChavePrimaria(AlunoSingleTable.class, ConstantesGerais.CPF_123_456_789_01);
	}
	
	private static void inserir() {
		InterfaceDAO dao = new DAOConcreto();
		dao.inserir(
			// Tipo escolhido aleatoriamente
			SubMainHerancaSingleTable.getInstanciaAlunoJoaoSingleTable()
		);
	}
	
	public static void alterar() {
		InterfaceDAO dao = new DAOConcreto();
		
		AlunoSingleTable alunoSingleTable = SubMainHerancaSingleTable.getInstanciaAlunoJoaoSingleTable();
		alunoSingleTable.setNome("David?");
		
		dao.alterar(
			// Tipo escolhido aleatoriamente
			alunoSingleTable
		);
	}
	
	private static void alterar(Entidade pEntidade) {
		InterfaceDAO dao = new DAOConcreto();
		
		AlunoSingleTable alunoSingleTable = (AlunoSingleTable) pEntidade;
		alunoSingleTable.setNome("David?");
		
		dao.alterar(
			alunoSingleTable
		);
	}
	
	public static void excluirPorObjeto() {
		InterfaceDAO dao = new DAOConcreto();
		dao.excluirPorObjeto(
			SubMainHerancaSingleTable.getInstanciaAlunoJoaoSingleTable());
	}
	
	private static void excluirPorChavePrimaria(Object pChavePrimaria) {
		InterfaceDAO dao = new DAOConcreto();
		dao.excluirPorChavePrimaria(
			AlunoSingleTable.class, 
			pChavePrimaria);
	}
	
	
}