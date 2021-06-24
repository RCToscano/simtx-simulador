package br.gov.caixa.simtx.simulador.testes.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class Conexao {
	
	private static final Logger logger = Logger.getLogger(Conexao.class);

	public static void main(String[] args) throws Exception {
		String query = "SELECT sysdate FROM dual";

		try (Connection connection = Conexao.obterConexao();
				PreparedStatement statement = connection.prepareStatement(query);) {
			ResultSet resultSet = statement.executeQuery(query);
			
			if (resultSet.next()) {
				System.out.println(resultSet.getDate("sysdate"));
			}
		}
	}

	public static Connection obterConexao() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:31521:ORCLCDB", "SYS as SYSDBA", "Oradoc_db1");
//			return DriverManager.getConnection("jdbc:oracle:thin:@10.116.92.130:3660:ORADES01", "F747250", "Caneta03");
		} 
		catch (SQLException e) {
			logger.error(e);
			throw e;
		} catch (ClassNotFoundException e) {
			logger.error(e);
			throw new SQLException();
		}
	}

}
