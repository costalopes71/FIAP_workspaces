package br.com.fiap.ddd.ead.aula06.dao;

import br.com.fiap.ddd.ead.aula06.expeption.CommitExption;
import br.com.fiap.ddd.ead.aula06.expeption.KeyNotFoundException;

public interface GenericDAO<T,K> {
	
	void inserir(T entidade);
	
	void atualizar(T entidade);
	
	void remover(K codigo) throws KeyNotFoundException;
	
	T pesquisar(K codigo);
	
	void commit() throws CommitExption;
}
