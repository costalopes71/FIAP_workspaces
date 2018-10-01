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
@Table(name="T_DBE_PACIENTE")
@SequenceGenerator(name="paciente", sequenceName="SQ_T_DBE_PACIENTE", allocationSize=1, initialValue=10)
public class Paciente {

	@Id
	@Column(name="cd_paciente")
	@GeneratedValue(generator="paciente", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_paciente", nullable=false, length=100)
	private String nome;
	
	@Column(name="dt_nascimento", nullable=false)
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	
	@Column(name="st_doador", nullable=false)
	private boolean doador;

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
