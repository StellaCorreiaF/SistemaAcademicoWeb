<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="br.edu.ifs.dao.*" %>
<%@ page import="br.edu.ifs.model.*" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Sistema Acadêmico - Listar Usuário Paginado</title>
<!-- BootStrap CSS -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap-4.0.0-dist/css/bootstrap.min.css">
	</head>
	<body>
	
	<%@ include file="MenuUsuario.jsp" %>
	
	<% 
		int linhas = 5; 
		int paginaAtual = 1; 
		int paginaInicial = 1;
		
		if (request.getParameter("linhas") != null) {
			linhas = Integer.parseInt(request.getParameter("linhas"));
		}
		
		if (request.getParameter("paginaAtual") != null) {
			paginaAtual = Integer.parseInt(request.getParameter("paginaAtual")); 
		}
		
		if (request.getParameter("paginaInicial") != null) {
			paginaInicial = Integer.parseInt(request.getParameter("paginaInicial"));
		}
	%>
		<table class="table">
	  <thead class="thead-dark">
	    <tr>
	      <th scope="col">ID</th>
	      <th scope="col">Nome</th>
	      <th scope="col">Login</th>
	      <th scope="col">Senha</th>
	      <th scope="col">Ações</th>
	    </tr>
	  </thead>
	  <tbody>
	  
	  	<%
	  		IFabricaConexoes fabrica = new FabricaConexoesPostgres();
	  		IUsuarioDAO usuarioDAO = new UsuarioDAOPostgres(fabrica.obterConexao());
	  		
	  		int totalUsuarios = usuarioDAO.recuperarTotalUsuarios();
	  		int totalPaginas = totalUsuarios / linhas;
	  		
	  		if ((totalUsuarios % linhas ) > 0) {
	  			totalPaginas++;
	  		}
	  		List<Usuario> listaUsuarios = usuarioDAO.listar(linhas, paginaAtual);
	  		
	  		for (Usuario usuario: listaUsuarios) {
	  		
	  	%>
	  	
	  	
		    <tr>
		      
		      <td><%=usuario.getId()%></td>
		      <td><%=usuario.getNome()%></td>
		      <td><%=usuario.getLogin()%></td>
		      <td><%=usuario.getSenha()%></td>
		      <td>
		      	<a class="btn btn-danger" role="button" href="<%=request.getContextPath()%>/usuario/ExcluirUsuario.jsp?id=<%=usuario.getId()%>">Excluir</a>
		      </td>
		      <td>
		      	<a class="btn btn-warning" role="button" href="<%=request.getContextPath()%>/usuario/AlterarUsuario.jsp?id=<%=usuario.getId()%>">Alterar</a>
		      </td>
		      		 
		    </tr>
		    
		    
		    
		 <% } %>
	    
	  </tbody>
	  <tfoot>
	  <tr>
	  		<td colspan="5" bgcolor="#eead2d" aligin= "center">
	  		<%
	  		
	  			for (int i = paginaInicial; i<=paginaInicial + 9; i++){
	  				if (i<=totalPaginas){
	  					if (i == paginaAtual){
	  						out.println("" + i);
	  					} else {
	  						if (i > 5) {
	  							out.println("<a href=\"ListarUsuarioPaginado.jsp?linhas=" + linhas + "&paginaAtual=" + i
	  									+ "&paginaInicial=" + (i - 4) + "\">" +i + "</a>");
	  							
	  						}
	  						else {
	  							out.println("<a href=\"ListarUsuarioPaginado.jsp?linhas=" + linhas + "&paginaAtual=" + i
	  									+ "&paginaInicial=" + 1 + "\">" +i + "</a>");
	  						}
	  					}
	  					
	  				}
	  			}
	  		
	  		
	  		%>
	  </tr>
	  </tfoot>
	</table>


	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script	src="<%=request.getContextPath()%>/resources/bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>
	
	
	</body>
</html>