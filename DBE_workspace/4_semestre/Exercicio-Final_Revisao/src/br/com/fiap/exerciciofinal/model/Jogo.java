package br.com.fiap.exerciciofinal.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@SequenceGenerator(name="jogo",allocationSize=1)
public class Jogo {
	
	@Id
	@GeneratedValue(generator="jogo",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@NotBlank(message="Campo de preenchimento obrigatório.")
	private String nome;
	
	@Past(message="Data de lançamento não pode ser maior que a data atual.")
	private Calendar dataLancamento;
	
	private boolean disponivel;
	
	@NotNull(message="Escolha uma plataforma.")
	private Plataforma plataforma;
	
	@NotNull(message="Escolha um gênero.")
	@ManyToOne
	private Genero genero;

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

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public Plataforma getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}
