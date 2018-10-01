package br.com.fiap.ads.ead.aula06.daoImpl;

import javax.persistence.EntityManager;

import br.com.fiap.ads.ead.aula06.dao.NotaFiscalDAO;
import br.com.fiap.ads.ead.aula06.entities.NotaFiscal;

public class NotaFiscalDAOImpl extends GenericDAOImpl<NotaFiscal, Integer> implements NotaFiscalDAO {

	public NotaFiscalDAOImpl(EntityManager em) {
		super(em);
	}
	
}
