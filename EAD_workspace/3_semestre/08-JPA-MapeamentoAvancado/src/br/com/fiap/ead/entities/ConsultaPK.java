package br.com.fiap.ead.entities;

import java.io.Serializable;
import java.util.Calendar;

//Classe que possui os atributos que foram a chave composta
//Obrigatorio implementar Serializable
public class ConsultaPK implements Serializable {

	private static final long serialVersionUID = 7082801656690500067L;

	private long medico;
	
	private int paciente;
	
	private Calendar dataConsulta;
	
	public ConsultaPK() {

	}

	public ConsultaPK(long medico, int paciente, Calendar data) {
		super();
		this.medico = medico;
		this.paciente = paciente;
		this.dataConsulta = data;
	}

	public long getMedico() {
		return medico;
	}

	public void setMedico(long medico) {
		this.medico = medico;
	}

	public int getPaciente() {
		return paciente;
	}

	public void setPaciente(int paciente) {
		this.paciente = paciente;
	}

	public Calendar getData() {
		return dataConsulta;
	}

	public void setData(Calendar data) {
		this.dataConsulta = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataConsulta == null) ? 0 : dataConsulta.hashCode());
		result = prime * result + (int) (medico ^ (medico >>> 32));
		result = prime * result + paciente;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsultaPK other = (ConsultaPK) obj;
		if (dataConsulta == null) {
			if (other.dataConsulta != null)
				return false;
		} else if (!dataConsulta.equals(other.dataConsulta))
			return false;
		if (medico != other.medico)
			return false;
		if (paciente != other.paciente)
			return false;
		return true;
	}
	
}
