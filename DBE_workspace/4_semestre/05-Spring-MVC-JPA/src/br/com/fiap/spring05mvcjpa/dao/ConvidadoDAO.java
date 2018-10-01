package br.com.fiap.spring05mvcjpa.dao;

import java.util.List;

import br.com.fiap.spring05mvcjpa.model.Convidado;

public interface ConvidadoDAO extends GenericDAO<Convidado, Integer> {

	List<Convidado> listarEmOrdemAlfabetica();
	void confirmar(int codigo);
	List<Convidado> pesquisarPor(String nome);
	
}
