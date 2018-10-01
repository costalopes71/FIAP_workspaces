package br.com.fiap.ads.ead.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.ads.ead.dao.MotoristaDAO;
import br.com.fiap.ads.ead.entities.Motorista;

public class MotoristaDAOImpl extends GenericDAOImpl<Motorista, Integer> implements MotoristaDAO {

	public MotoristaDAOImpl(EntityManager em) {
		super(em);
	}

}
