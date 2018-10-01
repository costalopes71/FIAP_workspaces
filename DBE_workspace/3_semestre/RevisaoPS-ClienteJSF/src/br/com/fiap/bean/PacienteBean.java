package br.com.fiap.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.service.PacienteService;
import br.com.fiap.to.Paciente;

@ManagedBean
public class PacienteBean {

	private Paciente paciente;
	private PacienteService service;
	
	@PostConstruct
	public void init() {
		paciente = new Paciente();
		service = new PacienteService();
	}
	
	public String salvar() {
		
		FacesMessage msg = null;
		try {
			if (paciente.getId() == 0) {
				service.cadastrar(paciente);
				msg = new FacesMessage("Paciente cadastrado com sucesso!");
			} else {
				service.atualizar(paciente);
				msg = new FacesMessage("Paciente atualizado com sucesso!");
			}
		} catch (Exception e) {
			msg = new FacesMessage(e.getMessage());
		}
		
		FacesContext.getCurrentInstance().addMessage("msg", msg);
		return "listar-pacientes?faces-redirect=true";
	}

	public String deletar(int id) {
		FacesMessage msg = null;
		try {
			service.deletar(id);
			msg = new FacesMessage("Paciente deletado!");
		} catch (Exception e) {
			msg = new FacesMessage("ERRO ao tentar deletar o paciente!");
		}
		
		FacesContext.getCurrentInstance().addMessage("msg", msg);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		return "listar-pacientes?faces-redirect=true";
	}
	
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public List<Paciente> getPacientes() {
		try {
			return service.listar();
		} catch (Exception e) {
			return null;
		}
	}
	
}
