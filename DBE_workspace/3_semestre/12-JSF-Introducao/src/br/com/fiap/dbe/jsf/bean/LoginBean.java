package br.com.fiap.dbe.jsf.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginBean {

	private String usuario;
	private String senha;
	
	public void logar() {
		if (usuario.equals("FIAP") && senha.equals("FIAP2018")) {
			System.out.println("LOGADO COM SUCESSO!");
		} else {
			System.out.println("Login incorreto MTF!");
		}
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
