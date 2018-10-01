package br.com.fiap.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="REVISAO_DBE_IMOVEL")
@SequenceGenerator(name="imovel", sequenceName="SQ_REVISAO_DBE_IMOVEL", allocationSize=1)
public class Imovel {

	@Id
	@Column(name="id_imovel")
	@GeneratedValue(generator="imovel", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="ds_endereco", nullable=false, length=200)
	private String endereco;
	
	@Column(name="vl_preco", nullable=false)
	private double preco;
	
	@Column(name="st_residencial")
	private boolean residencial;
	
	public Imovel() {

	}

	public Imovel(String endereco, double preco, boolean residencial) {
		this.endereco = endereco;
		this.preco = preco;
		this.residencial = residencial;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public boolean isResidencial() {
		return residencial;
	}

	public void setResidencial(boolean residencial) {
		this.residencial = residencial;
	}
	
}
