package br.com.fiap.exerciciofinal.dao;

import java.util.List;

import br.com.fiap.exerciciofinal.model.Jogo;

public interface JogoDAO extends GenericDAO<Jogo, Integer>{

	void disponibilizar(int codigo);
	
	List<Jogo> buscarPorGenero(int genero);
	
	List<Jogo> buscarPorNome(String nome);
	
}
