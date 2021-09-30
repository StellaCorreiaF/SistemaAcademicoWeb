<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.edu.ifs.model.Aluno" %>
<%@ page import="br.edu.ifs.dao.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1, shink-to-fit=no">	
		<title>Sistema Acadêmico - Excluir Usuário </title>
		
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
		
		<h2> Excluir Usuário </h2>
		
		<form method= "post" action=" <%=request.getContextPath()%>/ExcluirAluno.do">
			<input type= "hidden" name= "id" value="<%=aluno.getId()%>">
			<p> Nome: <%=aluno.getNome() %> </p>
			<p> Curso <%=aluno.getCurso() %> </p>
			<p> Login: <%=aluno.getLogin() %> </p>
			<br>
			<br>
			<input type="submit" value="Excluir Aluno" class="btn btn-success">
		</form>
		
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-Dfxdz2htPH0lsSSs5nCTpuj/zy4c+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="ananymous"></script>
		
		<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
		
	</body>
</html>