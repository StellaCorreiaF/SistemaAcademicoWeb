package br.edu.ifs.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifs.dao.FabricaConexoesPostgres;
import br.edu.ifs.dao.IFabricaConexoes;
import br.edu.ifs.dao.IAlunoDAO;
import br.edu.ifs.dao.AlunoDAOPostgres;
import br.edu.ifs.model.Aluno;


/**
 * Servlet implementation class AlterarProfessor
 */
@WebServlet({ "/AlterarAluno.do", "/AlterarAluno" })
public class AlterarAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarAluno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Id = request.getParameter("id");
		String Nome = request.getParameter("nome");
		String Curso = request.getParameter("curso");
		String Login = request.getParameter("login");
		String Senha = request.getParameter("senha");
		
		try {
			
			Aluno aluno = new Aluno();
			aluno.setId(Integer.parseInt(Id));
			aluno.setNome(Nome);
			aluno.setCurso(Curso);
			aluno.setLogin(Login);
			aluno.setSenha(Senha);
			
			IFabricaConexoes fabrica = new FabricaConexoesPostgres();
			IAlunoDAO alunoDAO = new AlunoDAOPostgres(fabrica.obterConexao());
			alunoDAO.atualizar(aluno);
			
			response.sendRedirect("professor/ListarAluno.jsp");
		}
		catch (SQLException e) {
			request.getSession().setAttribute("erro", e.getMessage().toString());
			response.sendRedirect("erro/ExibirErro.jsp");
		}
		catch (ClassNotFoundException e) {
			request.getSession().setAttribute("erro", e.getMessage().toString());
			response.sendRedirect("erro/ExibirErro.jsp");
		}
		
		
	}

}
