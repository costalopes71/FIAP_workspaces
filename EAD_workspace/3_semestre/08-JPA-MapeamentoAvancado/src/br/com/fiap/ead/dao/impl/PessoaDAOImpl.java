package br.com.fiap.ead.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.ead.dao.PessoaDAO;
import br.com.fiap.ead.entities.Pessoa;

public class PessoaDAOImpl extends GenericDAOImpl<Pessoa, Integer> implements PessoaDAO{

	public PessoaDAOImpl(EntityManager em) {
		super(em);
	}

	
	
}
