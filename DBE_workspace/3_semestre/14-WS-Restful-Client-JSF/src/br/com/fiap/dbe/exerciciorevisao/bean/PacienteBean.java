package br.com.fiap.dbe.exerciciorevisao.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.dbe.exerciciorevisao.service.PacienteService;
import br.com.fiap.dbe.exerciciorevisao.to.Paciente;

@ManagedBean
public class PacienteBean {

	private Paciente paciente;
	private PacienteService service;
	
	@PostConstruct
	private void init() {
		paciente = new Paciente();
		service = new PacienteService();
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public String salvar() {
		FacesMessage msg;
		
		try {
			if (paciente.getCodigo() == 0) {
				service.cadastrar(paciente);
				msg = new FacesMessage("Cadastrado com sucesso!");
			} else {
				service.atualizar(paciente);
				msg = new FacesMessage("Atualizado com sucesso!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ao tentar cadastrar.");
		}
		
		FacesContext.getCurrentInstance().addMessage("msg", msg);
		// matem a mensagem no proximo request depois do redirect
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		return "lista-paciente?faces-redirect=true";
	}
	
	public List<Paciente> getPacientes() {
		try {
			return service.listar();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String deletar(int codigo) {
		FacesMessage msg;
		try {
			service.deletar(codigo);
			msg = new FacesMessage("Deletado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ao deletar!");
		}
		FacesContext.getCurrentInstance().addMessage("msg", msg);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		return "lista-paciente?faces-redirect=true";
	}
	
}
