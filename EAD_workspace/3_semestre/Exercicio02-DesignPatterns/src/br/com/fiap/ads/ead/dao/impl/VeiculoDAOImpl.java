package br.com.fiap.ads.ead.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.ads.ead.dao.VeiculoDAO;
import br.com.fiap.ads.ead.entities.Veiculo;

public class VeiculoDAOImpl extends GenericDAOImpl<Veiculo, Integer> implements VeiculoDAO {

	public VeiculoDAOImpl(EntityManager em) {
		super(em);
	}

}
