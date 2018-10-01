package br.com.fiap.dbe.exerciciorevisao.to;

import java.io.Serializable;
import java.util.Calendar;

public class Paciente implements Serializable {

	private static final long serialVersionUID = -5044832500188634817L;
	
	private int codigo;
	private String nome;
	private Calendar dataNascimento;
	private boolean doador;
	
	public Paciente() {
		dataNascimento = Calendar.getInstance();
	}
	
	public Paciente(String nome, Calendar dataNascimento, boolean doador) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.doador = doador;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
