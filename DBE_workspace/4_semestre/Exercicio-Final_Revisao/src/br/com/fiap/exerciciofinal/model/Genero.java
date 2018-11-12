package br.com.fiap.exerciciofinal.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@SequenceGenerator(name="genero",allocationSize=1)
public class Genero {

	@Id
	@GeneratedValue(generator="genero",strategy=GenerationType.SEQUENCE)
	private Integer codigo;
	
	@NotBlank
	private String nome;
	
	@OneToMany(mappedBy="genero")
	private List<Jogo> jogos;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}
	
	
}
