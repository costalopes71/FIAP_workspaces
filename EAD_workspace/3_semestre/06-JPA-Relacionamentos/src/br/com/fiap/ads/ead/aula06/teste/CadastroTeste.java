package br.com.fiap.ads.ead.aula06.teste;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.ads.ead.aula06.dao.NotaFiscalDAO;
import br.com.fiap.ads.ead.aula06.daoImpl.NotaFiscalDAOImpl;
import br.com.fiap.ads.ead.aula06.entities.Imposto;
import br.com.fiap.ads.ead.aula06.entities.ItemPedido;
import br.com.fiap.ads.ead.aula06.entities.NotaFiscal;
import br.com.fiap.ads.ead.aula06.entities.Pedido;
import br.com.fiap.ads.ead.aula06.exception.CommitExption;
import br.com.fiap.ads.ead.aula06.singleton.EntityManagerFactorySingleton;

public class CadastroTeste {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
		EntityManager em = emf.createEntityManager();
		
//		Pedido p = new Pedido(Calendar.getInstance(), "pedido da fabrica de Campinas.");
//		NotaFiscal notaFiscal = new NotaFiscal(Calendar.getInstance(), 999.11, p);
//		
		NotaFiscalDAO daoFiscal = new NotaFiscalDAOImpl(em);
////		PedidoDAOImpl daoPedido = new PedidoDAOImpl(em);
//		
////		daoPedido.inserir(p);
//		daoFiscal.inserir(notaFiscal);
//		try {
//			daoFiscal.commit();
//		} catch (CommitExption e) {
//			e.printStackTrace();
//		}

		Pedido p = new Pedido(Calendar.getInstance(), "2 chaveiros");
		NotaFiscal nf = new NotaFiscal(Calendar.getInstance(), 10.50, p);
		
		Imposto imposto = new Imposto();
		Imposto imposto2 = new Imposto();
		imposto.setDescricao("ICMS");
		imposto2.setDescricao("IOF");
		imposto.setValor(0.08);
		imposto2.setValor(0.06);
		
		List<Imposto> impostos = Arrays.asList(imposto, imposto2);
		nf.setImpostos(impostos);
		
		ItemPedido[] ip = {
			new ItemPedido("chaveiro do palmeiras", 5.00),
			new ItemPedido("chaveiro do sao paulo", 5.50)
		};
//			new ItemPedido("pizza de palmito", 11.00),
//			new ItemPedido("pizza de peperoni", 15.00),
//			new ItemPedido("pizza de brocolis", 9.00),
//			new ItemPedido("pizza de 4 queijos", 15.00),
//			new ItemPedido("pizza de berinjela", 10.00),
//			new ItemPedido("pizza de abobrinha", 10.00),
//			new ItemPedido( "pizza de chocolate", 10.00),
//		};
		
		for (ItemPedido itemPedido : ip) {
			p.adicionarItem(itemPedido);
		}
		
		try {
			daoFiscal.inserir(nf);
			daoFiscal.commit();
		} catch (CommitExption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		em.close();
		emf.close();
		
	}
	
}
