package br.com.fiap.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fiap.bo.CarrinhoCompraBO;

@ManagedBean
@SessionScoped
public class CarrinhoBean {

	private String item;
	private List<String> listaItens;
	
	@PostConstruct
	private void init() {
		listaItens = carrinhoBO.checkout();
	}
	
	@EJB
	private CarrinhoCompraBO carrinhoBO;

	public void adicionar() {
		carrinhoBO.adicionarItem(item);
		listaItens = carrinhoBO.checkout();
	}
	
	public List<String> listar() {
		return listaItens;
	}
	
	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public List<String> getListaItens() {
		return listaItens;
	}

	public void setListaItens(List<String> listaItens) {
		this.listaItens = listaItens;
	}

}
