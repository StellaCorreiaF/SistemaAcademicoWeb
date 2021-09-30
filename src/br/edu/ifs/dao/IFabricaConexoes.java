package br.edu.ifs.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface IFabricaConexoes {
	
	Connection obterConexao() throws ClassNotFoundException, SQLException;
	
	
	
	

}
