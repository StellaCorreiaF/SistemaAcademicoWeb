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
	<title>Sistema Acadêmico - Alterar Usuário</title>
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
		
		<h2>Alterar Usuário</h2>
	<form method="post"
		action="<%=request.getContextPath()%>/AlterarUsuario.do">
		<label for="nome">Nome:</label>
		<input type="text" id="nome" name="nome" value="<%=usuario.getNome()%>">
		<input type="hidden" name="id" value="<%=usuario.getId() %>">
		<br> 
		<br>
		<label for="login">Login:</label>
		<input type="text" id="login" name="login" value="<%=usuario.getLogin()%>">
		<br>
		<br>
		<label for="senha">Senha:</label> <input type="password" id="senha"	name="senha" value="<%=usuario.getSenha()%>">
		<br>
		<br>
		<input type="submit" value="Alterar Usuário" class="btn btn-success">
	</form>
		
		
	<!-- Inserindo o Jquery -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>
	</body>
</html>