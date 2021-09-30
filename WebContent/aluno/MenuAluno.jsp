<nav class= "navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="#">Usuário</a>
	
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
			role="button" data-toggle="dropdown" aria-haspopoup="true"
			aria-expanded="false"> Ações</a>
			<div class="dropdown-menu" aria-labelledby="navbarDropdown">
				
					<a class="dropdown-item" href="<%=request.getContextPath()%>/aluno/CadastarAluno.jsp">Cadastrar Aluno</a>
					<a class="dropdown-item" href="<%=request.getContextPath()%>/aluno/ListarAluno.jsp">Listar Aluno</a>
					<a class="dropdown-item" href="<%=request.getContextPath()%>/aluno/CadastrarUsuario.jsp">Usuário</a>
					
							
			</div>
			</li>
		</ul>
		<form class="form-inline my-2-lg-0">
			<input class="form-conrol mr-sm-2" type="search"
				placeholder="Search" aria-label="search">
			<button class="btn btn-outline-success my-2-my-sm-0" type="submit">Search</button>
		</form>	
	</div>
</nav>