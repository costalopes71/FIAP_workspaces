package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.exceptions.CommitException;
import br.com.fiap.exceptions.IdNotFoundException;

public interface GenericDAO<T, K> {

	List<T> listar();
	void cadastrar(T entity);
	T pesquisar(K codigo);
	void atualizar(T entity);
	void deletar(K codigo) throws IdNotFoundException;
	void commit() throws CommitException;
	
}
