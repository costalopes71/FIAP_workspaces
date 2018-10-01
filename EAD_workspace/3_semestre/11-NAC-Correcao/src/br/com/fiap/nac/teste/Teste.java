package br.com.fiap.nac.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.nac.dao.ApartamentoDAO;
import br.com.fiap.nac.dao.ClienteDAO;
import br.com.fiap.nac.dao.LocacaoDAO;
import br.com.fiap.nac.dao.impl.ApartamentoDAOImpl;
import br.com.fiap.nac.dao.impl.ClienteDAOImpl;
import br.com.fiap.nac.dao.impl.LocacaoDAOImp;
import br.com.fiap.nac.entities.Apartamento;
import br.com.fiap.nac.entities.Cliente;
import br.com.fiap.nac.entities.Locacao;
import br.com.fiap.nac.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance(); 
		EntityManager em = emf.createEntityManager();
		LocacaoDAO dao = new LocacaoDAOImp(em);
		ClienteDAO daoCliente = new ClienteDAOImpl(em);
		ApartamentoDAO daoAp = new ApartamentoDAOImpl(em);
		
//		Cliente cliente = new Cliente("Joao Carlos Costa Lopes", new GregorianCalendar(1987, Calendar.JULY, 24), Sexo.MASCULINO);
//		Apartamento ap = new Apartamento("Rua Ilansa, 520 - Mooca", "casa térrea, 2 dormitórios, 200 metros quadradps", null);
//		
//		Locacao locacao = new Locacao(Calendar.getInstance(), new GregorianCalendar(2019, Calendar.JANUARY, 01), ap, cliente);
//		
//		dao.cadastrar(locacao);
//		try {
//			dao.salvar();
//		} catch (DBException e) {
//			System.out.println(e.getMessage());
//		}
		
		List<Locacao> locacoes = dao.buscarLocacaoPorData(new GregorianCalendar(1987, Calendar.JULY, 24), Calendar.getInstance());

		System.out.println("Por descricao:");

		for (Apartamento ape : daoAp.buscarApartamentoPorDescricao("c")) {
			System.out.println(ape.getDetalhes());
		}
		
		System.out.println("=============================");
		
		for (Cliente cliente : daoCliente.listar()) {
			System.out.println(cliente.getCodigo() + "\tNome: " + cliente.getNome());
		}
		
		long qtdLocacoes = dao.quantidadeDeLocacoesPorCliente(1);
		
		System.out.println("Qtd de locacoes por cliente: " + qtdLocacoes);
		
		for (Locacao loc : locacoes) {
			System.out.println(loc.getCliente().getNome());
		}
	
		em.close();
		emf.close();
		
	}
	
}
