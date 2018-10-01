package br.com.fiap.ads.ead.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="T_EAD_EX2_PAGAMENTO")
@Entity
@SequenceGenerator(name="pagamento", sequenceName="SQ_EAD_EX2_PAGAMEMTO", initialValue=1)
public class Pagamento {

	@Id
	@Column(name="cd_pagamento")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pagamento")
	private int codigo;
	
	@Column(name="dt_pagamento", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataPagamento;
	
	@Column(name="vl_pagamento", nullable=false)
	private float valorPagamento;
	
	@Column(name="ds_forma_pagamento", nullable=false)
	@Enumerated(EnumType.STRING)
	private TipoPagamento formaPagamento;

	@OneToOne(mappedBy="pagamento")
	private Corrida corrida;
	
	public Pagamento() { }
	
	public Pagamento(Calendar dataPagamento, float valorPagamento, TipoPagamento formaPagamento) {
		super();
		this.dataPagamento = dataPagamento;
		this.valorPagamento = valorPagamento;
		this.formaPagamento = formaPagamento;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Calendar dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public float getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(float valorPagamento) {
		this.valorPagamento = valorPagamento;
	}

	public TipoPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(TipoPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Corrida getCorrida() {
		return corrida;
	}

	public void setCorrida(Corrida corrida) {
		this.corrida = corrida;
	}

}
