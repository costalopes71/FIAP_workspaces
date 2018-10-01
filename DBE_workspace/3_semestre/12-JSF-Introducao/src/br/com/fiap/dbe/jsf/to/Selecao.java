package br.com.fiap.dbe.jsf.to;

import java.io.Serializable;

public class Selecao implements Serializable {

	private static final long serialVersionUID = -4405059816461339530L;
	private int codigo;
	private String pais;
	private boolean classificado;
	private int numeroMundiais;

	public Selecao() { }
	
	public Selecao(String pais, boolean classificado, int numeroMundiais) {
		this.pais = pais;
		this.classificado = classificado;
		this.numeroMundiais = numeroMundiais;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public boolean isClassificado() {
		return classificado;
	}

	public void setClassificado(boolean classificado) {
		this.classificado = classificado;
	}

	public int getNumeroMundiais() {
		return numeroMundiais;
	}

	public void setNumeroMundiais(int numeroMundiais) {
		this.numeroMundiais = numeroMundiais;
	}
	
}
