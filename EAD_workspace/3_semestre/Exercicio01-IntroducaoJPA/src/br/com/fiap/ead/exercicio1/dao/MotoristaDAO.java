package br.com.fiap.ead.exercicio1.dao;

import javax.persistence.EntityManager;

import br.com.fiap.ead.exercicio1.entities.Motorista;
import br.com.fiap.ead.exercicio1.exceptions.CommitException;
import br.com.fiap.ead.exercicio1.exceptions.NoResultsException;

public interface MotoristaDAO {

	void inserir(Motorista motorista);
	Motorista pesquisar(int codigo);
	void atualizar(Motorista motorista);
	void deletar(int codigo) throws NoResultsException;
	
	default void commit(EntityManager em) throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
			throw new CommitException("Erro no commit.");
		}
	}
	
}
