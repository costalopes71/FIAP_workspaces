package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class PacoteDAOImpl extends GenericDAOImpl<Pacote,Integer> implements PacoteDAO{

	public PacoteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Pacote> buscarPorDatas(Calendar inicio, Calendar fim) {
		TypedQuery<Pacote> query = em.createQuery("FROM Pacote p WHERE p.dataSaida between :pDtInicio AND :pDtFim", Pacote.class);
		query.setParameter("pDtFim", fim).setParameter("pDtInicio", inicio);
		return query.getResultList();
	}

	@Override
	public List<Pacote> pesquisarPorTransporte(Transporte transporte) {
		return em.createQuery("from Pacote p where p.transporte = :t",Pacote.class)
				.setParameter("t", transporte)
				.getResultList();
	}

	@Override
	public double calcularMediaPreco() {
		return em.createQuery("SELECT AVG(p.preco) FROM Pacote p", Double.class).getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pacote> buscarPorDestino(String destino) {
		return em.createNativeQuery("SELECT * FROM JPA_T_PACOTE WHERE ds_pacote LIKE :pDestino", Pacote.class).setParameter("pDestino", "%" + destino + "%").getResultList();
	}

	@Override
	public long contarPorTrasnporte() {
		return em.createNamedQuery("Pacote.contarPorTrasnporte", Long.class).getSingleResult();
	}

}
