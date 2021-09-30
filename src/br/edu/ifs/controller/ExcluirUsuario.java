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
import br.edu.ifs.dao.IUsuarioDAO;
import br.edu.ifs.dao.UsuarioDAOPostgres;
import br.edu.ifs.model.Usuario;

/**
 * Servlet implementation class ExcluirUsuario
 */
@WebServlet("/ExcluirUsuario.do")
public class ExcluirUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirUsuario() {
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
		String id = request.getParameter("id");
		try {
			
			Usuario usuario = new Usuario();
			usuario.setId(Integer.parseInt(id));
						
			
			IFabricaConexoes fabrica = new FabricaConexoesPostgres();
			IUsuarioDAO usuarioDAO = new UsuarioDAOPostgres(fabrica.obterConexao());
			usuarioDAO.excluir(usuario);
			
			response.sendRedirect("usuario/ListarUsuarios.jsp");
				
		}
		
		catch (SQLException e) {
			request.getSession().setAttribute("erro", e.getMessage().toString());
			response.sendRedirect("erro/ExibirErro.jsp");
		}
		
		catch (ClassNotFoundException e) {
			request.getSession().setAttribute("erro",e.getMessage().toString());
			
			response.sendRedirect("erro/ExibirErro.jsp");
		}
	}

}
