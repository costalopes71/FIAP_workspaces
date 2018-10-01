package br.com.fiap.ads.ead.aula06.dao;

import br.com.fiap.ads.ead.aula06.exception.CommitExption;
import br.com.fiap.ads.ead.aula06.exception.KeyNotFoundException;

public interface GenericDAO<T,K> {
	
	void inserir(T entidade);
	
	void atualizar(T entidade);
	
	void remover(K codigo) throws KeyNotFoundException;
	
	T pesquisar(K codigo);
	
	void commit() throws CommitExption;
}
