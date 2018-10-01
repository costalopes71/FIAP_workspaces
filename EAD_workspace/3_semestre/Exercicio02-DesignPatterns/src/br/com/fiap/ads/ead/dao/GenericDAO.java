package br.com.fiap.ads.ead.dao;

import br.com.fiap.ads.ead.exceptions.CommitException;
import br.com.fiap.ads.ead.exceptions.KeyNotFoundException;

public interface GenericDAO<T, K> {

	void inserir(K entity);
	T pesquisar(K codigo);
	void alterar(T entity);
	void remover(K codigo) throws KeyNotFoundException;
	void commit() throws CommitException;
	
}
