package br.com.dbe.revisaonac.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@SequenceGenerator(name="marca", sequenceName="SQ_T_MARCA", allocationSize=1)
public class Marca {

	@Id
	@GeneratedValue(generator="marca", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@NotBlank(message="Atributo nome é requerido")
	private String nome;

	@OneToMany(mappedBy="marca", cascade=CascadeType.ALL)
	private List<Carro> carros;
	
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

}
