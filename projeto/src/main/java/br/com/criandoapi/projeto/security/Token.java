package br.com.criandoapi.projeto.security;

public class Token {
	private String token;

	public Token(String token) {
		super();
		this.setToken(token);
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
