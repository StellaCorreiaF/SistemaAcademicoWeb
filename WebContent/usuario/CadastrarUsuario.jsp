<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Sistema Acadêmico - Cadastrar Usuário</title>
<!-- BootStrap CSS -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap-4.0.0-dist/css/bootstrap.min.css">
</head>
<body>
	<%@ include file="MenuUsuario.jsp" %>

	<h2>Cadastrar Usuário</h2>
	<form method="post"
		action="<%=request.getContextPath()%>/CadastrarUsuario.do">
		<label for="nome">Nome:</label> <input type="text" id="nome"
			name="nome"> <br> <br> <label for="login">Login:</label>
		<input type="text" id="login" name="login"> <br> <br>
		<label for="senha">Senha:</label> <input type="password" id="senha"
			name="senha"> <br> <br> <input type="submit"
			value="Cadastrar Usuário" class="btn btn-success">
	</form>
	<!-- Inserindo o Jquery -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>

</body>
</html>