package br.com.fiap.nac.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import br.com.fiap.nac.dao.ApartamentoDAO;
import br.com.fiap.nac.entities.Apartamento;


public class ApartamentoDAOImpl extends GenericDAOImpl<Apartamento, Integer> implements ApartamentoDAO {

	public ApartamentoDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Apartamento> buscarApartamentoPorDescricao(String descricao) {
		return em.createQuery("SELECT a FROM Apartamento a WHERE a.detalhes LIKE '%" + descricao + "%'", Apartamento.class).
				getResultList();
	}

}
