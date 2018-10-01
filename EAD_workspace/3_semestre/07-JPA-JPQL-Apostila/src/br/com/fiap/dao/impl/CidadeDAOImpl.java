package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.entity.Cidade;

public class CidadeDAOImpl extends GenericDAOImpl<Cidade,Integer> implements CidadeDAO{

	public CidadeDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

//	@Override
//	public List<Cidade> listar() {
//		TypedQuery<Cidade> query = em.createQuery("FROM Cidade", Cidade.class);
//		return query.getResultList();
//	}

	@Override
	public List<Cidade> buscarPorNome(String nome) {
		TypedQuery<Cidade> query = em.createQuery("FROM Cidade c WHERE c.nome LIKE :nomeCidade", Cidade.class);
		query.setParameter("nomeCidade", "%" + nome + "%");
		return query.getResultList();
	}

}
