package br.unibratec.linhasaereas.persistencia;

import java.util.Collection;

import br.unibratec.linhasaereas.entidades.Passageiro;
import br.unibratec.persistencia.AbstractDAO;

public class PassageiroDAO extends AbstractDAO implements IPassageiroDAO {
	
	public static final String NAMED_QUERY_CONSULTAR_TODOS_PASSAGEIROS = "CONSULTAR_TODOS_PASSAGEIROS";
	
	public Passageiro consultar(Object pChavePrimaria) {
		Passageiro registro = 
			(Passageiro) super.consultarPorChavePrimaria(
							Passageiro.class, 
							pChavePrimaria);
		
		return registro;
	}
	
	public Collection<Passageiro> consultar() {
		return 
			super.consultarNamedQuery(
				NAMED_QUERY_CONSULTAR_TODOS_PASSAGEIROS, 
				Passageiro.class);
	}
	
	/*private void testarConexaoJDBC() {
		IConnectionFactory conexao = new ConnectionFactory();
		conexao.getConnection();
	}*/
	
}