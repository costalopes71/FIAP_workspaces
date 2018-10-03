package br.com.dbe.revisaonac.dao;

import java.util.List;

import br.com.dbe.revisaonac.exceptions.KeyNotFoundException;

public interface GenericDAO<T,K> {

	void inserir(T entidade);
	List<T> listar();
	void atualizar(T entidade);
	void remover(K codigo) throws KeyNotFoundException;
	T pesquisar(K codigo);
	
}



