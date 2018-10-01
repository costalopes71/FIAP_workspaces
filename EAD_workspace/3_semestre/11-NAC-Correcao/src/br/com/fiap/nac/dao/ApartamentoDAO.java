package br.com.fiap.nac.dao;

import java.util.List;

import br.com.fiap.nac.entities.Apartamento;

public interface ApartamentoDAO extends GenericDAO<Apartamento, Integer>{

	List<Apartamento> buscarApartamentoPorDescricao(String descricao);
	
}
