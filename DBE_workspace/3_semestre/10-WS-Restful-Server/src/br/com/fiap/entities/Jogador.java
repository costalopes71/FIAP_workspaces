package br.com.fiap.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_DBE_JOGADOR")
@SequenceGenerator(name="jogador", sequenceName="SQ_DBE_JOGADOR", initialValue=1, allocationSize=1)
public class Jogador {

	@Id
	@GeneratedValue(generator="jogador", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_jogador")
	private int codigo;
	
	@Column(name="nm_jogador", nullable=false, length=50)
	private String nome;
	
	@Column(name="nr_camisa", nullable=false, length=3)
	private int numero;
	
	@Column(name="st_titular", nullable=false)
	private boolean titular;

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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isTitular() {
		return titular;
	}

	public void setTitular(boolean titular) {
		this.titular = titular;
	}
	
}
