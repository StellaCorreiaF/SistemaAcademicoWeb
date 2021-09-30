package br.edu.ifs.model;

public class Aluno {
	
	private int id;
	private String nome;
	private String curso;
	private String login;
	private String senha;
	
	public Aluno (int id, String nome, String curso, String login, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.curso = curso;
		this.login = login;
		this.senha = senha;
	}
	
	public Aluno (String nome, String curso, String login, String senha) {
		super();
		this.nome = nome;
		this.curso = curso;
		this.login = login;
		this.senha = senha;
	}
	

	public Aluno () {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
			

}

