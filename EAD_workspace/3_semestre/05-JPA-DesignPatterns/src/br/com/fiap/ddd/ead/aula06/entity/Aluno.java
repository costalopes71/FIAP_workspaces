package br.com.fiap.ddd.ead.aula06.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_EAD2_ALUNO")
public class Aluno {

	@Id
	@Column(name="cd_aluno")
	private String rm;

	@Column(name = "nm_aluno", nullable = false, length = 150)
	private String nome;

	public Aluno() {
		super();
	}

	public Aluno(String rm, String nome) {
		super();
		this.rm = rm;
		this.nome = nome;
	}

	public String getRm() {
		return rm;
	}

	public void setRm(String rm) {
		this.rm = rm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
