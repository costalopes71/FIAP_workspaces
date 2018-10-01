package br.com.fiap.ads.ead.aula06.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_EAD_PEDIDO")
@SequenceGenerator(name="pedido", sequenceName="SQ_EAD_T_PEDIDO", initialValue=1, allocationSize=1)
public class Pedido {

	@Id
	@Column(name="cd_pedido")
	@GeneratedValue(generator="pedido", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="dt_pedido", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	
	@Column(name="ds_pedido", nullable=false, length=300)
	private String descricao;
	
	@OneToOne(mappedBy="pedido", fetch=FetchType.LAZY)
	private NotaFiscal notaFiscal;
	
	@OneToMany(mappedBy="pedido", cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<ItemPedido> itens = new ArrayList<>();
	
	public Pedido() { }

	public Pedido(Calendar data, String descricao) {
		super();
		this.data = data;
		this.descricao = descricao;
	}

	public void adicionarItem(ItemPedido item) {
		itens.add(item);
		item.setPedido(this);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

}
