package br.edu.ifs.dao;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifs.model.Usuario;


public interface IUsuarioDAO {
	
	//CRUD// 
	
	public int criar(Usuario usuario) throws SQLException;
	public Usuario recuperar(int id) throws Exception, SQLException;
	public boolean atualizar(Usuario usuario) throws SQLException;
	public boolean excluir(Usuario usuario) throws SQLException;
	
	//outras funcionalidades
	public List<Usuario> listar() throws SQLException;
	public List<Usuario> listar(int linhas, int paginas) throws SQLException;
	public int recuperarTotalUsuarios () throws SQLException;
	public Usuario autenticar(String login, String senha) throws SQLException;
	

}
