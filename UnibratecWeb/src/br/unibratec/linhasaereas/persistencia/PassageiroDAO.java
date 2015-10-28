package br.unibratec.linhasaereas.persistencia;

import br.unibratec.linhasaereas.entidades.Passageiro;
import br.unibratec.persistencia.AbstractDAO;

public class PassageiroDAO extends AbstractDAO implements IPassageiroDAO {
	
	public Passageiro consultar(Object pChavePrimaria) {
		Passageiro registro = 
			(Passageiro) super.consultarPorChavePrimaria(
							Passageiro.class, 
							pChavePrimaria);
		
		return registro;
	}
	
	public void testarConexaoJDBC() {
		IConnectionFactory conexao = new ConnectionFactory();
		conexao.getConnection();
	}
	
}