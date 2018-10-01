package br.com.fiap.bean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.service.VendaService;
import br.com.fiap.to.Venda;

@ManagedBean
public class VendaBean {

	private VendaService service;
	private Venda venda;
	
	@PostConstruct
	public void init() {
		service = new VendaService();
		venda = new Venda();
		venda.setData(Calendar.getInstance());
	}

	public String salvar() {
		FacesMessage msg = null;
		try {
			if (venda.getId() == 0) {
				service.cadastrar(venda);
				msg = new FacesMessage("Venda cadastrada com sucesso!");
			} else {
				service.atualizar(venda);
				msg = new FacesMessage("Venda atualizada com sucesso!");
			}			
		} catch (Exception e) {
			msg = new FacesMessage("Erro!\n" + e.getMessage());
		}
		FacesContext.getCurrentInstance().addMessage("msg", msg);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		return "listar-vendas?faces-redirect=true"; 
	}
	
	public String deletar(int id) {
		FacesMessage msg = null;
		try {
			service.deletar(id);
			msg = new FacesMessage("Item deletado.");
		} catch (Exception e) {
			msg = new FacesMessage("Erro ao deletar.\n" + e.getMessage());
		}
		FacesContext.getCurrentInstance().addMessage("msg", msg);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		return "listar-vendas?faces-redirect=true";
	}
	
	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	public List<Venda> getVendas() {
		try {
			return service.listar();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
