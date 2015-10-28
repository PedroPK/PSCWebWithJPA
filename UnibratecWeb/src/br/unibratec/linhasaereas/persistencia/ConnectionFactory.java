package br.unibratec.linhasaereas.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionFactory implements IConnectionFactory {
	
	public Connection getConnection() {
		Connection conexao = null;
		
		try {
			// Registra o Drive 
			Class.forName("com.mysql.jdbc.Driver");
			
			// Tenta criar a conexão
			String urlConexao = "jdbc:mysql://localhost:3306/unibratec";
			
			Properties propriedadesConexaoMySQL = new Properties();
			propriedadesConexaoMySQL.put("user", "root");
			propriedadesConexaoMySQL.put("password", "");
			
			conexao = DriverManager.getConnection(urlConexao, propriedadesConexaoMySQL);
			
			System.out.println("Estamos conectados am MySQL!");
			
			conexao.close();
		} catch ( ClassNotFoundException cnfE ) {
			System.out.println(cnfE.toString());
			System.out.println("Deu algum erro no Registro do Drive JDBC do MySQL...");
		} catch ( SQLException sqlE ) {
			System.out.println(sqlE.toString());
			System.out.println("Deu algum erro na obtenção da Conexão...");
		}
		
		return conexao;
	}
	
}
