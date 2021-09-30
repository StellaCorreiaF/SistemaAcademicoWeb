<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.edu.ifs.model.*" %>
<%@ page import="br.edu.ifs.dao.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1, shink-to-fit=no">	
		<title>Sistema Acadêmico - Alterar Usuário </title>
		
		<link rel="styLesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
		
	</head>
	<body>
	
		<%@ include file="MenuAluno.jsp" %>
		
		<%
			int id = 0;		
			id = Integer.parseInt(request.getParameter("id").toString());
			Aluno aluno = new Aluno();
		
			try{
				
				IFabricaConexoes fabrica = new FabricaConexoesPostgres();
				IAlunoDAO alunoDao = new AlunoDAOPostgres(fabrica.obterConexao());
				aluno = alunoDao.recuperar(id);
			}
			
			catch (Exception e) {
				request.getSession().setAttribute("erro", e.getMessage().toString());
				response.sendRedirect("../erro/ExibirErro.jsp");
			}
			
		%>
		
		<h2> Alterar Aluno </h2>
		
		<form method= "post" action=" <%=request.getContextPath()%>/AlterarAluno.do">
			<label for="nome">Nome:</label>
			<input type= "hidden" name= "id" value="<%=aluno.getId()%>">
			<input type="text" id="nome" name="nome" value="<%=aluno.getNome()%>">
			<br>	
			<br>
			<label for="formacao">Curso:</label>
			<input type="text" id="formacao" name="curso" value="<%=aluno.getCurso()%>">
			<br>	
			<br>
			<label for="login">Login:</label>
			<input type="text" id="login" name="login" value="<%=aluno.getLogin()%>">
			<br>
			<br>
			<label for="senha">Senha:</label>
			<input type="password" id="senha" name="senha" value="<%=aluno.getSenha()%>">
			<br>
			<br>
			<input type="submit" value="Alterar Professor" class="btn btn-success">
		</form>
		
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-Dfxdz2htPH0lsSSs5nCTpuj/zy4c+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="ananymous"></script>
		
		<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
		
	</body>
</html>