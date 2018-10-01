package br.com.fiap.ead.dao;

import br.com.fiap.ead.exception.CommitException;
import br.com.fiap.ead.exception.KeyNotFoundException;

public interface GenericDAO<T,K> {

	void inserir(T entidade);
	
	void atualizar(T entidade);
	
	void remover(K codigo) throws KeyNotFoundException;
	
	T pesquisar(K codigo);
	
	void commit() throws CommitException;
	
}



