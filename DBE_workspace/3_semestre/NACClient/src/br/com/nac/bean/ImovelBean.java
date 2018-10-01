package br.com.nac.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.nac.entity.Imovel;
import br.com.nac.service.ImovelService;

@ManagedBean
public class ImovelBean {

	private Imovel imovel;
	private ImovelService service;
	
	@PostConstruct
	public void init() {
		imovel = new Imovel();
		service = new ImovelService();
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	
	public String salvar() {
		FacesMessage msg = null;
		try {
			service.cadastrar(imovel);
			msg = new FacesMessage("Imovel cadastrado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage(e.getMessage());
		}
		FacesContext.getCurrentInstance().addMessage("msg", msg);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		return "imovel?faces-redirect=true";
	}

	public List<Imovel> getLista() {
		try {
			return service.listar();
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage msg = new FacesMessage("Erro ao listar! " + e.getMessage());
			FacesContext.getCurrentInstance().addMessage("msg", msg);
			return null;
		}
	}
	
}
