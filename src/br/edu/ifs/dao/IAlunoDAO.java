package br.edu.ifs.dao;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifs.model.Aluno;


public interface IAlunoDAO {
	
	public int criar(Aluno aluno) throws SQLException;
	public Aluno recuperar(int id) throws Exception, SQLException;
	public List<Aluno> listar() throws SQLException;
	public boolean atualizar(Aluno aluno) throws SQLException;
	public boolean excluir(Aluno aluno) throws SQLException;

}
