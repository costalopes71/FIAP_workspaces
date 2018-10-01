package br.com.fiap.bo.impl;

import javax.ejb.Singleton;

import br.com.fiap.bo.ContadorBO;

@Singleton
public class ContadorBOImpl implements ContadorBO {

	private int visitas;

	@Override
	public void incrementar() {
		visitas++;
	}

	@Override
	public int verTotal() {
		return visitas;
	}
	
}
