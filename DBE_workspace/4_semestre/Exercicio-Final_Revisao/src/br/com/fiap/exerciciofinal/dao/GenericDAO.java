package br.com.fiap.exerciciofinal.dao;

import java.util.List;

import br.com.fiap.exerciciofinal.exception.RegistroNaoEncontradoException;

public interface GenericDAO <Tabela, Chave> {

	void cadastrar(Tabela tabela);
	
	void atualizar(Tabela tabela);
	
	void excluir(Chave codigo) throws RegistroNaoEncontradoException;
	
	Tabela buscar(Chave codigo);
	
	List<Tabela> listar();
	
}


