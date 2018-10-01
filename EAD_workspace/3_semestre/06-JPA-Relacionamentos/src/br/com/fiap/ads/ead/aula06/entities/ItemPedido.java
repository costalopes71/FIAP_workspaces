package br.com.fiap.ads.ead.aula06.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_EAD_ITEM_PEDIDO")
@SequenceGenerator(name="item", sequenceName="SQ_EAD_ITEM_PEDIDO", allocationSize=1, initialValue=1)
public class ItemPedido {

	@Id
	@Column(name="cd_item")
	@GeneratedValue(generator="item", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@ManyToOne
	@JoinColumn(name="cd_pedido")
	private Pedido pedido;
	
	@Column(name="ds_item", nullable=false, length=300)
	private String descricao;
	
	@Column(name="vl_item")
	private double valor;

	public ItemPedido() { }
	
	public ItemPedido(String descricao, double valor) {
		this.descricao = descricao;
		this.valor = valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
