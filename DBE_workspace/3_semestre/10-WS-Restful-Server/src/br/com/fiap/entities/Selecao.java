package br.com.fiap.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_DBE_SELECAO")
@SequenceGenerator(name="selecao", sequenceName="SQ_T_DBE_SELECAO", initialValue=1, allocationSize=1)
public class Selecao {

	@Id
	@Column(name="cd_selecao")
	@GeneratedValue(generator="selecao", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_pais", nullable=false, length=50, unique=true)
	private String pais;
	
	@Column(name="st_classificado", nullable=false)
	private boolean classificado;
	
	@Column(name="nr_mundiais", nullable=false, length=4)
	private int numeroMundiais;

	public Selecao() { }
	
	public Selecao(String pais, boolean classificado, int numeroMundiais) {
		this.pais = pais;
		this.classificado = classificado;
		this.numeroMundiais = numeroMundiais;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public boolean isClassificado() {
		return classificado;
	}

	public void setClassificado(boolean classificado) {
		this.classificado = classificado;
	}

	public int getNumeroMundiais() {
		return numeroMundiais;
	}

	public void setNumeroMundiais(int numeroMundiais) {
		this.numeroMundiais = numeroMundiais;
	}
	
}
