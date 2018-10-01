package br.com.fiap.bo;

import javax.ejb.Remote;

@Remote
public interface ContadorBO {

	void incrementar();
	int verTotal();
	
}
