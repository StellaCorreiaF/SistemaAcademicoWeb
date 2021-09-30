<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.edu.ifs.model.Usuario" %>
<%@ page import="br.edu.ifs.dao.*" %>
<%@ page import="br.edu.ifs.model.*" %>
<!DOCTYPE html>
<html>
	<head>
	<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Sistema Acad�mico - Alterar Usu�rio</title>
	<!-- BootStrap CSS -->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap-4.0.0-dist/css/bootstrap.min.css">
	</head>
	<body>
		<%@ include file="MenuUsuario.jsp" %>
		
		<% 
			 int id = Integer.parseInt(request.getParameter("id").toString());
			 Usuario usuario = new Usuario();
			 
			 try {
					
					IFabricaConexoes fabrica = new FabricaConexoesPostgres();
					IUsuarioDAO usuarioDao = new UsuarioDAOPostgres(fabrica.obterConexao());
					usuario = usuarioDao.recuperar(id);
				}
				catch (Exception e ) {
					request.getSession().setAttribute("erro", e.getMessage().toString());
					response.sendRedirect("../erro/ExibirErro.jsp");
				}
				
		%>
		
		<h2>Excluir Usu�rio</h2>
	<form method="post"
		action="<%=request.getContextPath()%>/ExcluirUsuario.do">
		<input type="hidden" name="id" value="<%=usuario.getId()%>">
		<p>Nome: <%=usuario.getNome()%> </p>
		<p>Login: <%=usuario.getLogin()%> </p>
		<br> 
		<br>
		
		<input type="submit" value="Excluir Usu�rio" class="btn btn-success">
	</form>
		
		
	<!-- Inserindo o Jquery -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>
	</body>
</html>