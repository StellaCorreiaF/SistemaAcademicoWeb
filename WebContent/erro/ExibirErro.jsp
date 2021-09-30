<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
			<title>Sistema Acadêmico -  Erro</title>
	</head>
	<body>
		<%
			String descricaoErro = (String) request.getSession().getAttribute("erro");
		%>
			<p> <%=descricaoErro %> </p>
	</body>
</html>