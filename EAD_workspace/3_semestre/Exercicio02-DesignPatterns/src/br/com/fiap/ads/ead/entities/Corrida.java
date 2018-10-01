package br.com.fiap.ads.ead.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="T_EAD_EX2_CORRIDA")
@Entity
@SequenceGenerator(sequenceName="SQ_EAD_EX2_CORRIDA", name="corrida", initialValue=1)
public class Corrida {

	@Id
	@Column(name="cd_corrida")
	@GeneratedValue(generator="corrida", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="ds_origem", length=150)
	private String origem;
	
	@Column(name="ds_destino", length=150)
	private String destino;
	
	@Column(name="dt_corrida")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCorrida;

	@Column(name="vl_corrida", nullable=false)
	private float valorCorrida;
	
	@ManyToOne
	@JoinColumn(name="cd_motorista", nullable=false)
	private Motorista motorista;
	
	@ManyToOne
	@JoinColumn(name="cd_passageiro", nullable=false)
	private Passageiro passageiro;
	
	@OneToOne
	@JoinColumn(name="cd_pagamento")
	private Pagamento pagamento;
	
	public Corrida() { }
	
	public Corrida(String origem, String destino, Calendar dataCorrida, float valorCorrida) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.dataCorrida = dataCorrida;
		this.valorCorrida = valorCorrida;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Calendar getDataCorrida() {
		return dataCorrida;
	}

	public void setDataCorrida(Calendar dataCorrida) {
		this.dataCorrida = dataCorrida;
	}

	public float getValorCorrida() {
		return valorCorrida;
	}

	public void setValorCorrida(float valorCorrida) {
		this.valorCorrida = valorCorrida;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public Passageiro getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
}
