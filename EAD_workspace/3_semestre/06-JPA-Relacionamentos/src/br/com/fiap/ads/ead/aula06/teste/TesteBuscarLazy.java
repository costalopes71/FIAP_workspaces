package br.com.fiap.ads.ead.aula06.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.ads.ead.aula06.dao.PedidoDAO;
import br.com.fiap.ads.ead.aula06.daoImpl.PedidoDAOImpl;
import br.com.fiap.ads.ead.aula06.singleton.EntityManagerFactorySingleton;

public class TesteBuscarLazy {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
		EntityManager em = emf.createEntityManager();
		PedidoDAO daoPedido = new PedidoDAOImpl(em);
		
		daoPedido.pesquisar(22);
		
		
	}
	
}
