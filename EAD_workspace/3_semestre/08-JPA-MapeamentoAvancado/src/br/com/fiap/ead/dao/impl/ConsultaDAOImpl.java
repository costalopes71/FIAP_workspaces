package br.com.fiap.ead.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.ead.dao.ConsultaDAO;
import br.com.fiap.ead.entities.Consulta;
import br.com.fiap.ead.entities.ConsultaPK;

public class ConsultaDAOImpl extends GenericDAOImpl<Consulta, ConsultaPK> implements ConsultaDAO {

	public ConsultaDAOImpl(EntityManager em) {
		super(em);
	}
	
}
