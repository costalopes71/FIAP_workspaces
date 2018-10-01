package br.com.fiap.to;

import java.io.Serializable;

/**
 * Classe que representa um produto.
 * @author Joao Lopes
 * @since 21/02/2018
 * @version 1.0
 */
public class ProdutoTO implements Serializable{

	private static final long serialVersionUID = 8607206204701115650L;
	private int codigo;
	private String nome;
	private double preco;
	private String descricao;

	public ProdutoTO() {
		
		}

	
	public ProdutoTO(int codigo, String nome, double preco, String descricao) {
			super();
			this.codigo = codigo;
			this.nome = nome;
			this.preco = preco;
			this.descricao = descricao;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", nome=" + nome + ", preco=" + preco + ", descricao=" + descricao + "]";
	}

}
