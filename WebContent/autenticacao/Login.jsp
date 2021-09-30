<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Sistema Academico - Login Usuário</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap-4.0.0-dist/css/bootstrap.min.css">
	</head>
	<body>
		<h1>Login do Usuário</h1>
		
		<form method="post" action="<%=request.getContextPath()%>/AutenticarUsuario.do">
			<label for="login">Login:</label>
			<input type="text" id="login" name="login">
			<br><br>
			<label for="senha">Senha:</label> <input type="password" id="senha" name="senha">
			<br><br> <input type="submit" value="Autenticar"> ${msg}
		</form>
		
	
		<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	
		<script	src="<%=request.getContextPath()%>/resources/bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>
	</body>
</html>