package br.com.fiap.nac.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.nac.dao.LocacaoDAO;
import br.com.fiap.nac.entities.Locacao;

public class LocacaoDAOImp extends GenericDAOImpl<Locacao, Integer> implements LocacaoDAO {

	public LocacaoDAOImp(EntityManager em) {
		super(em);
	}

	//Buscar todas as locações que possuem a data de inicio entre duas datas.
	@Override
	public List<Locacao> buscarLocacaoPorData(Calendar inicio, Calendar fim) {

		return em.createQuery("FROM Locacao l where l.dataInicio BETWEEN :pInicio AND :pFim", Locacao.class).
				setParameter("pInicio", inicio).
				setParameter("pFim", fim).
				getResultList();
	}

	@Override
	public long quantidadeDeLocacoesPorCliente(int codigoCliente) {
		return em.createQuery("SELECT COUNT(l) FROM Locacao l WHERE l.cliente.codigo = :pCodigoCliente", Long.class).
				setParameter("pCodigoCliente", codigoCliente).getSingleResult();
	}

}
