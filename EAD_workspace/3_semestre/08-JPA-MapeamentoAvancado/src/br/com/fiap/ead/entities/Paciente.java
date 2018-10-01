package br.com.fiap.ead.entities;

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
@Table(name="T_EAD_PACIENTE")
@SequenceGenerator(name="paciente", sequenceName="SQ_T__EAD_PACIENTE", initialValue=1, allocationSize=1)
public class Paciente {

	@Id
	@GeneratedValue(generator="paciente", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_paciente")
	private int codigo;
	
	@Column(name="nm_paciente", nullable=false, length=250)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento", nullable=false)
	private Calendar dataNascimento;
	
	public Paciente() {

	}

	public Paciente(String nome, Calendar dataNascimento) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
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
	
}
