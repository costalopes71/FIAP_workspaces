package br.com.fiap.ead.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_EAD_PESSOA")
@Inheritance(strategy=InheritanceType.JOINED) //posso usar tbm a estrategia de single table ou table per class (esse ultimo
//nao eh usado)
//se for single table posso discriminar o nome da coluna DTYPE -->
//@DiscriminatorColumn(name"DS_TIPO")
//@DiscriminatorValue("P") --> serve para discriminar o valor que sera gravado no banco ao inves do nome da entidade, preciso por essa mesma
//anotacao nas outras classe para discriminar o valor que quero no caso delas.
@SequenceGenerator(name="pessoa", sequenceName="SQ_T_DBE_PESSOA", allocationSize=1, initialValue=1)
public class Pessoa {

	@Id
	@GeneratedValue(generator="pessoa",strategy=GenerationType.SEQUENCE)
	private int codigo;

	@Column(name="nm_pessoa", nullable=false, length=250)
	private String nome;
	
	@Column(name="ds_endereco", length=500)
	private String endereco;

	public Pessoa() {

	}
	
	public Pessoa(String nome, String endereco) {
		super();
		this.nome = nome;
		this.endereco = endereco;
	}

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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}
