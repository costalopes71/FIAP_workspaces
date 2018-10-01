package br.com.fiap.ddd.ead.aula06.daoImpl;

import javax.persistence.EntityManager;

import br.com.fiap.ddd.ead.aula06.dao.LivroDAO;
import br.com.fiap.ddd.ead.aula06.entity.Livro;

public class LivroDAOImpl extends GenericDAOImpl<Livro, Integer> implements LivroDAO{

	public LivroDAOImpl(EntityManager em) {
		super(em);
	}

	
}
