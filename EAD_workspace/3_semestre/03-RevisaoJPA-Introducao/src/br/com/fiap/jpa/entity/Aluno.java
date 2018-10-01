package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

//Em uma entidade (classe que sera uma tabela no banco) duas anotações são obrigatorias : Entity e Id

@Entity
@Table(name="T_EAD_ALUNO")
@SequenceGenerator(name="aluno", sequenceName="SQ_T_ALUNO", allocationSize=1)
public class Aluno implements Serializable {

	public Aluno() {
	
	}
	
	public Aluno(String nome, String curso, Calendar dataNascimento, boolean matriculado, Periodo periodo,
			Integer semestre, String token, byte[] foto) {
		super();
		this.nome = nome;
		this.curso = curso;
		this.dataNascimento = dataNascimento;
		this.matriculado = matriculado;
		this.periodo = periodo;
		this.semestre = semestre;
		this.token = token;
		this.foto = foto;
	}

	private static final long serialVersionUID = -7795953869025102726L;
	
	@Id
	@GeneratedValue(generator="aluno", strategy=GenerationType.SEQUENCE)
	@Column(name="id_aluno")
	private int rm;
	@Column(name="nm_aluno", nullable=false, length=150)
	private String nome;
	@Column(name="ds_curso", length=50)
	private String curso;
	@Column(name="dt_nascimento", nullable=false)
	@Temporal(TemporalType.DATE) //utiliza somente a data para gravar no banco, se por TIMESTAMP pega a data e a hora, se for TIME pega somento a hora 
	private Calendar dataNascimento;
	@Column(name="st_matriculado", nullable=false)
	private boolean matriculado;
	@Column(name="ds_periodo")
	@Enumerated(EnumType.STRING) //dessa maneira ele grava o texto do enum e nao um valor numerico!!
	private Periodo periodo;
	//ATENCAO: aqui é bom usar a wrapper class (Integer) pois esse campo pode ser nulo no banco de dados
	//e o java inicializa atributo int com 0, logo o semestre ficaria gravado no banco com o valor 0, usando
	//a wrapper class ele aceita ficar nulo
	@Column(name="qt_semestre")
	private Integer semestre;
	//da para usar outros 2 atributos chamados insertable e updatable (no insertable ele nao vai deixar inserir e no updatable nao deixa
	//atualizar)
	
	@Transient //serve para nao gravar no banco, eh um atributo que sera usado no meu sistema mas nao ha necessidade de gravar ele no banco
	private String token;

	@Lob //gravar arquivo no banco (BLOB no banco)
	@Column(name="fl_foto")
	private byte[] foto;

	public int getRm() {
		return rm;
	}

	public void setRm(int rm) {
		this.rm = rm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public boolean isMatriculado() {
		return matriculado;
	}

	public void setMatriculado(boolean matriculado) {
		this.matriculado = matriculado;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public Integer getSemestre() {
		return semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
	
}