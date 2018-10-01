package br.com.fiap.dao;

import java.util.Collection;
import java.util.List;
import br.com.fiap.entity.Cidade;

public interface CidadeDAO extends GenericDAO<Cidade,Integer>{

	List<Cidade> buscarPorNome(String nome);
	List<Cidade> buscarPorEstados(Collection<String> estados);
	
}
