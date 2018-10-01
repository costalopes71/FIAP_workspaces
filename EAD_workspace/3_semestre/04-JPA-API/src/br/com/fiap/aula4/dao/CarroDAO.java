package br.com.fiap.aula4.dao;

import br.com.fiap.aula04.entities.Carro;
import br.com.fiap.aula4.exceptions.CarNotFoundException;
import br.com.fiap.aula4.exceptions.CommitException;

public interface CarroDAO {

	void create(Carro carro);
	void update(Carro carro);
	void delete(int codigo) throws CarNotFoundException;
	Carro find(int codigo);
	void commit() throws CommitException;
	
}
