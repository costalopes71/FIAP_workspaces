package br.com.fiap.ead.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="T_EAD_PESSOA_JURIDICA")
public class PessoaJuridica extends Pessoa {

	@Column(name="nr_cnpj", nullable=false, length=100)
	private String cnpj;
	
	@Column(name="nr_razao_social", nullable=false, length=100)
	private String razaoSocial;

	public PessoaJuridica() {

	}
	
	public PessoaJuridica(String nome, String endereco, String cnpj, String razaoSocial) {
		super(nome, endereco);
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

}
