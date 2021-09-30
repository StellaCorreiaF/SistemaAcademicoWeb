<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1, shink-to-fit=no">
		<title>Sistema Acadêmico - Cadastrar Aluno</title>
		
		<link rel="styLesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
		
</head>
	<body>
	
		<%@ include file="MenuAluno.jsp" %>
			
		<h2> Cadastrar Aluno </h2>
		
		<form action="<%=request.getContextPath()%>/CadastrarAluno.do" method="post">
			<label for="nome">Nome:</label>
			<input type="text" id="nome" name="nome">
			<br>	
			<br>
			<label for="formacao">Curso:</label>
			<input type="text" id="curso" name="curso">
			<br>
			<br>
			<label for="login">Login:</label>
			<input type="text" id="login" name="login">
			<br>
			<br>
			<label for="senha">Senha:</label>
			<input type="password" id="senha" name="senha">
			<br>
			<br>
			<input type="submit" value="Cadastrar Aluno"  class="btn btn-success">
		</form>
		
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-Dfxdz2htPH0lsSSs5nCTpuj/zy4c+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="ananymous"></script>
		
		<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
		
	</body>
</html>