package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.exceptions.CommitException;
import br.com.fiap.exceptions.IdNotFoundException;

public interface GenericDAO<T, K> {

	void cadastrar(T entity);
	T pesquisar(K id);
	List<T> listar();
	void atualizar(T entity);
	void deletar(K id) throws IdNotFoundException;
	void commit() throws CommitException;
	
}
