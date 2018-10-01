package br.com.fiap.ead.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name="T_EAD_MEDICO")
@SecondaryTable(name="T_EAD_MEDICO_FINANCEIRO")
public class Medico {

	@Id
	@Column(name="nr_crm", nullable=false, unique=true)
	private long crm;
	
	@Column(name="nm_medico", nullable=false, length=250)
	private String nome;
	
	@Column(name="ds_especialidade", length=100, nullable=false)
	@Enumerated(EnumType.STRING)
	private Especialidade especialidade;

	@Column(name="vl_salario", table="T_EAD_MEDICO_FINANCEIRO")
	private double salario;
	
	@Column(name="nr_conta_corrente", table="T_EAD_MEDICO_FINANCEIRO")
	private int contaCorrente;
	
	public Medico() {

	}
	
	public Medico(long crm, String nome, Especialidade especialidade, double salario, int contaCorrente) {
		super();
		this.crm = crm;
		this.nome = nome;
		this.especialidade = especialidade;
		this.salario = salario;
		this.contaCorrente = contaCorrente;
	}

	public Medico(long crm, String nome, Especialidade especialidade) {
		super();
		this.crm = crm;
		this.nome = nome;
		this.especialidade = especialidade;
	}

	public long getCrm() {
		return crm;
	}

	public void setCrm(long crm) {
		this.crm = crm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(int contaCorrente) {
		this.contaCorrente = contaCorrente;
	}
	
}
