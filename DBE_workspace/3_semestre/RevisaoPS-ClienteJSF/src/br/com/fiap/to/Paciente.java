package br.com.fiap.to;

import java.util.Calendar;

public class Paciente {

	private int id;
	private String nome;
	private Calendar dataNascimento;
	private boolean doador;
	
	public Paciente() { 
		this.dataNascimento = Calendar.getInstance();
	}

	public Paciente(String nome, Calendar dataNascimento, boolean doador) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.doador = doador;
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

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public boolean isDoador() {
		return doador;
	}

	public void setDoador(boolean doador) {
		this.doador = doador;
	}
	
}
