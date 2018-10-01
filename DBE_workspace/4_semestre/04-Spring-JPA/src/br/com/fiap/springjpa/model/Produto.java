package br.com.fiap.springjpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_SPR_PRODUTO")
@SequenceGenerator(name="produto", sequenceName="SEQ_SPR_PRODUTO", initialValue=1, allocationSize=1)
public class Produto {

	@Id
	@Column(name="cd_produto")
	@GeneratedValue(generator="produto", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_produto", nullable=false, length=50)
	private String nome;
	
	@Column(name="vl_produto", nullable=false)
	private double preco;
	
	@Column(name="st_perecivel", nullable=false)
	private boolean perecivel;

	public Produto() { }
	
	public Produto(String nome, double preco, boolean perecivel) {
		this.nome = nome;
		this.preco = preco;
		this.perecivel = perecivel;
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public boolean isPerecivel() {
		return perecivel;
	}

	public void setPerecivel(boolean perecivel) {
		this.perecivel = perecivel;
	}
	
}
