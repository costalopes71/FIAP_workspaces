package br.com.fiap.ead.exercicio1.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.ead.exercicio1.dao.VeiculoDAO;
import br.com.fiap.ead.exercicio1.entities.Veiculo;
import br.com.fiap.ead.exercicio1.exceptions.NoResultsException;

public class VeiculoDAOImpl implements VeiculoDAO {

	private EntityManager em;
	
	public VeiculoDAOImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void inserir(Veiculo v) {
		em.persist(v);
	}

	@Override
	public Veiculo pesquisar(int codigo) {
		return em.find(Veiculo.class, codigo);
	}

	@Override
	public void atualizar(Veiculo veiculo) {
		em.merge(veiculo);
	}

	@Override
	public void deletar(int codigo) throws NoResultsException {
		Veiculo veiculo = em.find(Veiculo.class, codigo);
		
		if (veiculo == null) {
			throw new NoResultsException("Veículo não encontrado.");
		}
		em.remove(veiculo);
	}

}
