package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private static final String URL = "jdbc:mysql://localhost:3307/sistema_funcionarios";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	
	public static Connection conectar() {
		try {
			Connection conn = 
					DriverManager.getConnection(URL,USER,PASSWORD);
			System.out.println("\t Conectado com sucesso!");
			return conn;
		} catch(Exception e) {
			System.out.println("\t Erro não Conexão!");
			e.printStackTrace();
			return null;
		}
	}
	
}
