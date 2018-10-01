package br.com.fiap.ads.ead.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.ads.ead.dao.PassageiroDAO;
import br.com.fiap.ads.ead.entities.Passageiro;

public class PassageiroDAOImpl extends GenericDAOImpl<Passageiro, Integer> implements PassageiroDAO {

	public PassageiroDAOImpl(EntityManager em) {
		super(em);
	}

}
