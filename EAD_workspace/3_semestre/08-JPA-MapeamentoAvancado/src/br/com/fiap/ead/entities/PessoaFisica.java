package br.com.fiap.ead.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="T_EAD_PESSOA_FISICA")
//@DiscriminatorValue("PF")
public class PessoaFisica extends Pessoa {
	
	@Column(name="nr_cpf", nullable=false, length=25)
	private String cpf;
	
	@Column(name="nr_rg", nullable=false, length=25)
	private String rg;

	public PessoaFisica() {
		super();
	}
	
	public PessoaFisica(String cpf, String rg, String nome, String endereco) {
		super(nome, endereco);
		this.cpf = cpf;
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	
}
