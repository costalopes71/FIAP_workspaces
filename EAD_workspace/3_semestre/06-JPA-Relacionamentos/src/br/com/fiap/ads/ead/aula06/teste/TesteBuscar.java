package br.com.fiap.ads.ead.aula06.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.ads.ead.aula06.dao.PedidoDAO;
import br.com.fiap.ads.ead.aula06.daoImpl.PedidoDAOImpl;
import br.com.fiap.ads.ead.aula06.entities.Pedido;
import br.com.fiap.ads.ead.aula06.singleton.EntityManagerFactorySingleton;

public class TesteBuscar {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
		EntityManager em = emf.createEntityManager();
		
		PedidoDAO dao = new PedidoDAOImpl(em);
		
		Pedido p = dao.pesquisar(2);
		
		System.out.println(p.getCodigo());
		System.out.println(p.getDescricao());
		System.out.println(p.getData());
		System.out.println(p.getNotaFiscal().getValor());
		
		em.close();
		emf.close();
		
	}
	
}
