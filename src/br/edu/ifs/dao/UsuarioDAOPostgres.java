package br.edu.ifs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifs.model.Usuario;

public class UsuarioDAOPostgres implements IUsuarioDAO {

	private Connection conexao; 
	
	public UsuarioDAOPostgres(Connection pConexao) {
		
		this.conexao = pConexao; 
	}
	
	@Override
	public int criar(Usuario usuario) throws SQLException {
		
		String sql = "INSERT INTO public.tb_usuario(nome, login, senha)	VALUES ( ?, ?, MD5(?))";
		
		int id = 0;
		
		try {
			
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			
			stmt.setString(1,  usuario.getNome());
			stmt.setString(2,  usuario.getLogin());
			stmt.setString(3,  usuario.getSenha());
			stmt.execute();
			
			sql = "SELECT CURRVAL(pg_get_serial_sequence('tb_usuario', 'id')) AS id";
			stmt = this.conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				
				id = rs.getInt("id");
				
			}
			
			return id; 
			
		}		catch (SQLException e ) {
			
			throw e;
		}
		finally {
			
		conexao.close();
	}
	}
	
	@Override
	public Usuario recuperar(int id) throws Exception, SQLException {
		
	String sql = "SELECT * FROM tb_usuario WHERE id= ?";
	
			try {
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();
				
				if (rs.next()) {
		Usuario usuario = new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("login"), rs.getString("senha"));
		
					return usuario; 
					
				} else {
					
					throw new  Exception ("O ID do usuário não existe"); 
				}
			} catch (SQLException e) {
				
				throw e ; 
				
			} finally {
				
				conexao.close();
			}
	}

	@Override
	public List<Usuario> listar() throws SQLException {
		
		String sql = "SELECT id, nome, login, senha FROM tb_usuario ORDER BY id";
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Usuario usuario = new Usuario(
						rs.getInt("id"),
						rs.getString("nome"),
						rs.getString("login"),
						rs.getString("senha")
				);
				listaUsuarios.add(usuario);
			}
			
			return listaUsuarios;
			
		}	catch (SQLException e) {
			
			throw e;
		}
		finally {
			
			conexao.close();
		}		
		
	}

	@Override
	public boolean atualizar(Usuario usuario) throws SQLException {
		String sql = "UPDATE tb_usuario SET nome=?, login=?, senha=MD5(?) WHERE id=?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1,  usuario.getNome());
			stmt.setString(2,  usuario.getLogin());
			stmt.setString(3,  usuario.getSenha());
			stmt.setInt(4,  usuario.getId());
			
			stmt.executeUpdate();
			
			return true;
		}  catch (SQLException e) {
			
			throw e;
			
		} finally {
			
			conexao.close();
		}
	}

	@Override
	public boolean excluir(Usuario usuario) throws SQLException {
		String sql = "DELETE FROM tb_usuario WHERE id=?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, usuario.getId());
			
			stmt.execute();
			return true;
		} catch (SQLException e) {
			throw e;
		} 
		finally {
			conexao.close();
		}
	}

	
	@Override
	public List<Usuario> listar(int linhas, int paginas) throws SQLException {
		
		String sql = "SELECT id, nome, login, senha FROM tb_usuario ORDER BY id LIMIT ? OFFSET ?";
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1,  linhas);
			stmt.setInt(2, (linhas*paginas) - linhas);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Usuario usuario = new Usuario(
						rs.getInt("id"),
						rs.getString("nome"),
						rs.getString("login"),
						rs.getString("senha")
				);
				listaUsuarios.add(usuario);
			}
			
			return listaUsuarios;
			
		}	catch (SQLException e) {
			
			throw e;
		}
		finally {
			
			conexao.close();
		}		
		
	}
	public int recuperarTotalUsuarios () throws SQLException {
		String sql = "SELECT COUNT(*) as TotalUsuarios FROM tb_usuario";
		int totalUsuarios = 0;
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				totalUsuarios = rs.getInt("totalUsuarios");
				
			}
			return totalUsuarios; 
			
		}catch (SQLException e) {
			throw e;
		}
	}
	@Override
	public Usuario autenticar(String login, String senha) throws SQLException {
		
		String sql = "SELECT * FROM tb_usuario WHERE login= ? AND senha = MD5(?)";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, login);
			stmt.setString(2, senha);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				Usuario usuario = new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("login"), rs.getString("senha"));
				return usuario;
			}
			else {
				
				return null;
				
			}
			
			
		
		} catch (SQLException e) {
			
		throw e;
		
	} finally {
		
		conexao.close();
	}
	}
	
	

}

	