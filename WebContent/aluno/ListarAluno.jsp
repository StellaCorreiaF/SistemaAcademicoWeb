<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.edu.ifs.dao.*"%>
<%@ page import="br.edu.ifs.model.*"%>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1, shink-to-fit=no">
		<title>Sistema Acadêmico - Listar Aluno</title>
		  
		<link rel="styLesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">

</head>
<body>
		<%@ include file="MenuAluno.jsp" %>
		
		<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Nome do Aluno</th>
      <th scope="col">Curso</th>
      <th scope="col">Login</th>
      <th scope="col">Senha</th>
      <th scope="col">Ações</th>

    </tr>
    
  </thead>
  <tbody>
  
  	<%
  		IFabricaConexoes fabrica = new FabricaConexoesPostgres();
  		IAlunoDAO alunoDAO = new AlunoDAOPostgres(fabrica.obterConexao());
  		List<Aluno> listaAluno = alunoDAO.listar();
  		
  		for(Aluno aluno: listaAluno) {
  	%>
  
    <tr>
      <td><%=aluno.getId()%></td>
      <td><%=aluno.getNome()%></td>
      <td><%=aluno.getCurso()%></td>
      <td><%=aluno.getLogin()%></td>
      <td><%=aluno.getSenha()%></td>
      <td>
      
      <a class= "btn btn-danger" role="button"href="<%=request.getContextPath()%>/aluno/ExcluirAluno.jsp?id=<%=aluno.getId()%>">Excluir</a>
      <a class= "btn btn-warning" role="button" href="<%=request.getContextPath()%>/aluno/AlterarAluno.jsp?id=<%=aluno.getId()%>">Alterar</a>
    </tr>
    
    <% } %>
    
  </tbody>
</table>

		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-Dfxdz2htPH0lsSSs5nCTpuj/zy4c+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="ananymous"></script>
		
		<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
		
</body>
</html>