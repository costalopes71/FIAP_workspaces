package br.com.fiap.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="T_EAD_AL5_PRODUTO")
@SequenceGenerator(name="produto", sequenceName="SQ_EAD_AL5_PRODUTO", initialValue=1, allocationSize=1)
public class ProdutoTO {

	@Id
	@GeneratedValue(generator="produto", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_produto", nullable=false)
	private String nome;
	
	@Column(name="ds_produto", nullable=false)
	private String descricao;
	
	@Column(name="vl_produto", nullable=false)
	private double preco;
	
	@Column(name="st_produto", nullable=false)
	private boolean disponivel;
	
	public ProdutoTO() {
		super();
	}

	public ProdutoTO(int codigo, String nome, String descricao, double preco, boolean disponivel) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.disponivel = disponivel;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
}
