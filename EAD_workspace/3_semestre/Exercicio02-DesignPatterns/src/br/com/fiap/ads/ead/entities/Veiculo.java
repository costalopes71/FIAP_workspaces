package br.com.fiap.ads.ead.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_EAD_EX2_VEICULO")
@SequenceGenerator(name="veiculo", sequenceName="SQ_EAD_EX2_T_VEICULO", allocationSize=1)
public class Veiculo implements Serializable {

	private static final long serialVersionUID = -5557847905060264855L;

	@Id
	@Column(name="cd_veiculo")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="veiculo")
	private int codigo;
	
	@Column(name="ds_placa", nullable=false, length=9)
	private String placa;
	
	@Column(name="ds_cor", nullable=false, length=20)
	private String cor;
	
	@Column(name="nr_ano")
	private int ano;

	@ManyToMany(mappedBy="veiculos")
	private List<Motorista> motoristas;
	
	public Veiculo() {

	}
	
	public Veiculo(String placa, String cor, int ano) {
		this.placa = placa;
		this.cor = cor;
		this.ano = ano;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public List<Motorista> getMotoristas() {
		return motoristas;
	}

	public void setMotoristas(List<Motorista> motoristas) {
		this.motoristas = motoristas;
	}
	
}
