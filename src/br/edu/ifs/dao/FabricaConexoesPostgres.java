package br.edu.ifs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexoesPostgres implements IFabricaConexoes {
	
	private static String DriverJDBC = "org.postegresql.Driver";
	private static String usuario = "postgres";
	private static String senha = "postgres";
	private static String URL="jdbc:postgresql://localhost:5432/SistemaAcademicoWeb";
	@Override
	public Connection obterConexao() throws ClassNotFoundException, SQLException {

		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection(URL, usuario, senha);
			
		}
		catch (SQLException e) {
			throw e; 
		}
	}
	public static String getDriverJDBC() {
		return DriverJDBC;
	}
	public static void setDriverJDBC(String driverJDBC) {
		DriverJDBC = driverJDBC;
	}

}
