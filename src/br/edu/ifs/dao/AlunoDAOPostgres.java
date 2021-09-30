package br.edu.ifs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifs.model.Usuario;

import br.edu.ifs.model.Aluno;

public class AlunoDAOPostgres implements IAlunoDAO {
	
	private Connection conexao;
	
	public AlunoDAOPostgres(Connection pConexao) {
		
		this.conexao = pConexao;
	}

	@Override
	public int criar(Aluno aluno) throws SQLException {
		
		
		String sql ="INSERT INTO public.tb_aluno(nome, curso, login, senha) VALUES (?, ?, ?, MD5(?))";
		
		int id = 0;
		
		try {
			
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getCurso());
			stmt.setString(3, aluno.getLogin());
			stmt.setString(4, aluno.getSenha());
			stmt.execute();
			
			sql = "SELECT CURRVAL(pg_get_serial_sequence('tb_aluno', 'id')) AS id";
			stmt = this.conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				
				id = rs.getInt("id");
			}
			
			return id;
			
		} catch (SQLException e) {
			throw e;
		}
		finally {
			conexao.close();
				
			}
			
		}
	
	@Override
	public Aluno recuperar(int id) throws Exception, SQLException {
		String sql = "SELECT * FROM tb_aluno WHERE id = ?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				Aluno aluno = new Aluno(rs.getInt("id"), rs.getString("nome"),rs.getString("curso"), rs.getString("login"), rs.getString("senha"));
				return aluno;
				
			} else {
				throw new Exception("O ID do aluno não existe.");
			}
			
		} catch (SQLException e) {
			throw e;
		}
		finally {
			
		}
	}

	@Override
	public List<Aluno> listar() throws SQLException {
		
		String sql = "SELECT id, nome, curso, login, senha FROM tb_aluno ORDER BY id";
		
		List<Aluno> listaAluno = new ArrayList<Aluno>();
		
		try {
			
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				Aluno aluno = new Aluno(rs.getInt("id"), rs.getString("nome"), rs.getString("curso"), rs.getString("login"), rs.getString("senha"));
				
				listaAluno.add(aluno);
			}
			
			return listaAluno;
			
		} catch (SQLException e) {
			throw e;
			
		}
		finally {
			conexao.close();
		}
		
	}

	@Override
	public boolean atualizar(Aluno aluno) throws SQLException {
		
		String sql = "UPDATE tb_aluno SET nome=?, curso=?, login=?, senha=MD5(?) where id=?";
		
		try {
			
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getCurso());
			stmt.setString(3, aluno.getLogin());
			stmt.setString(4, aluno.getSenha());
			stmt.setInt(5, aluno.getId());
			
			stmt.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			throw e;
			
		}
		finally {
			conexao.close();
		}
	}
	

	
	@Override
	public boolean excluir(Aluno aluno) throws SQLException {
		
		String sql = "DELETE FROM tb_aluno where id=?";
		
		try {
			
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			
			stmt.setInt(1, aluno.getId());
			
			stmt.execute();
			
			return true;
			
		} catch (SQLException e) {
			throw e;
		}
		finally {
			conexao.close();
		}
	}
}

