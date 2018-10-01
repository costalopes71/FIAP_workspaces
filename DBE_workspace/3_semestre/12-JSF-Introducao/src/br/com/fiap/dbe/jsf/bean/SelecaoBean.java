package br.com.fiap.dbe.jsf.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.dbe.jsf.service.SelecaoService;
import br.com.fiap.dbe.jsf.to.Selecao;

@ManagedBean
public class SelecaoBean {

	private Selecao selecao;
	private SelecaoService service;

	@PostConstruct
	private void init() {
		selecao = new Selecao();
		service = new SelecaoService();
	}
	
	public Selecao getSelecao() {
		return selecao;
	}

	public void setSelecao(Selecao selecao) {
		this.selecao = selecao;
	}
	
	//retorna a lista de selecoes para ser exibida em uma tabela HTML
	public List<Selecao> getSelecoes() {
		try {
			return service.listar();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void salvar() {
		//objeto para exibir msg na tela
		FacesMessage msg;
		
		try {
			if (selecao.getCodigo() == 0) {
				service.cadastrar(selecao);
				msg = new FacesMessage("Cadastrado!");
			} else {
				service.atualizar(selecao);
				msg = new FacesMessage("Atualizado!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro.");
		}
		
		//adiciona a mensagem para a tela exibir
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void deletar(int codigo) {
		FacesMessage msg;
		try {
			service.deletar(codigo);
			msg = new FacesMessage("Excluido com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ao deletar");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg); 
	}
	
}
