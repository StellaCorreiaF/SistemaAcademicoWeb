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
import br.edu.ifs.dao.IUsuarioDAO;
import br.edu.ifs.dao.AlunoDAOPostgres;
import br.edu.ifs.dao.UsuarioDAOPostgres;
import br.edu.ifs.model.Aluno;
import br.edu.ifs.model.Usuario;

/**
 * Servlet implementation class ExcluirAluno
 */
@WebServlet("/ExcluirAluno.do")
public class ExcluirAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirAluno() {
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
		try {
					
			Aluno aluno = new Aluno();
			aluno.setId(Integer.parseInt(Id));
						
				IFabricaConexoes fabrica = new FabricaConexoesPostgres();
				IAlunoDAO alunoDAO = new AlunoDAOPostgres(fabrica.obterConexao());
				alunoDAO.excluir(aluno);
					
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

