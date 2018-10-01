package br.com.fiap.ads.ead.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.ads.ead.dao.PagamentoDAO;
import br.com.fiap.ads.ead.entities.Pagamento;

public class PagamentoDAOImpl extends GenericDAOImpl<Pagamento, Integer> implements PagamentoDAO {

	public PagamentoDAOImpl(EntityManager em) {
		super(em);
	}

}
