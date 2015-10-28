package br.unibratec.linhasaereas.persistencia;

import java.sql.Connection;

public interface IConnectionFactory {
	
	public Connection getConnection();

}
