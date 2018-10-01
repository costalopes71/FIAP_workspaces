package br.com.fiap.ads.ead.aula06.daoImpl;

import javax.persistence.EntityManager;

import br.com.fiap.ads.ead.aula06.dao.PedidoDAO;
import br.com.fiap.ads.ead.aula06.entities.Pedido;

public class PedidoDAOImpl extends GenericDAOImpl<Pedido, Integer> implements PedidoDAO {

	public PedidoDAOImpl(EntityManager em) {
		super(em);
	}

}
