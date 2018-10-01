package br.com.fiap.entities;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="REVISAO_DBE_PACIENTE")
@SequenceGenerator(name="paciente", sequenceName="SQ_REVISAO_DBE_PACIENTE", allocationSize=1)
public class Paciente {

	@Id
	@Column(name="id_paciente")
	@GeneratedValue(generator="paciente", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="nm_paciente", nullable=false, length=200)
	private String nome;
	
	@Column(name="dt_nascimento")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	
	@Column(name="st_doador")
	private boolean doador;
	
	public Paciente() { }

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
