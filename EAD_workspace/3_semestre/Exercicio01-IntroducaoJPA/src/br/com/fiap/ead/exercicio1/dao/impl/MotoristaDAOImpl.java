package br.com.fiap.ead.exercicio1.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.ead.exercicio1.dao.MotoristaDAO;
import br.com.fiap.ead.exercicio1.entities.Motorista;
import br.com.fiap.ead.exercicio1.exceptions.NoResultsException;

public class MotoristaDAOImpl implements MotoristaDAO {

	private EntityManager em;

	public MotoristaDAOImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void inserir(Motorista motorista) {
		em.persist(motorista);
	}

	@Override
	public Motorista pesquisar(int codigo) {
		return em.find(Motorista.class, codigo);
	}

	@Override
	public void atualizar(Motorista motorista) {
		em.merge(motorista);
	}

	@Override
	public void deletar(int codigo) throws NoResultsException {
		Motorista motorista = em.find(Motorista.class, codigo);
		
		if (motorista == null) {
			throw new NoResultsException("Motorista não encontrado.");
		}
		em.remove(motorista);
	}
	
}
