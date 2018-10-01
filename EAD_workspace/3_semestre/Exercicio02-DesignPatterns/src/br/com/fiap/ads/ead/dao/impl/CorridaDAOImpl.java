package br.com.fiap.ads.ead.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.ads.ead.dao.CorridaDAO;
import br.com.fiap.ads.ead.entities.Corrida;

public class CorridaDAOImpl extends GenericDAOImpl<Corrida, Integer> implements CorridaDAO {

	public CorridaDAOImpl(EntityManager em) {
		super(em);
	}

}
