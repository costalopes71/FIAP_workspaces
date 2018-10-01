package br.com.fiap.ead.entities;

import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_EAD_CONSULTA")
@IdClass(ConsultaPK.class)
public class Consulta {

	@Id
	@JoinColumn(name="nr_crm", nullable=false)
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Medico medico;
	
	@Id
	@JoinColumn(name="cd_paciente", nullable=false)
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Paciente paciente;
	
	@Id
	@Column(name="dt_consulta", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataConsulta;
	
	@Column(name="ds_consultorio", length=100)
	private String consultorio;
	
	@Column(name="st_convenio")
	private boolean convenio;
	
	public Consulta() {

	}

	public Consulta(Medico medico, Paciente paciente, Calendar dataConsulta, String consultorio, boolean convenio) {
		super();
		this.medico = medico;
		this.paciente = paciente;
		this.dataConsulta = dataConsulta;
		this.consultorio = consultorio;
		this.convenio = convenio;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Calendar getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Calendar dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public String getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(String consultorio) {
		this.consultorio = consultorio;
	}

	public boolean isConvenio() {
		return convenio;
	}

	public void setConvenio(boolean convenio) {
		this.convenio = convenio;
	}
	
}
