package br.com.fiap.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.fiap.bo.ContadorBO;

@ManagedBean
public class ContadorBean {

	@EJB
	private ContadorBO bo;
	
	public void contar() {
		bo.incrementar();
	}
	
	public int getTotal() { 
		return bo.verTotal();
	}
	
}
