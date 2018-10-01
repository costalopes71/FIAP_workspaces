package br.com.fiap.view;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.ReservaDAOImpl;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;

public class ConsoleView {

	public static void main(String[] args) {
		EntityManagerFactory fabrica =
			EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//Listar as cidades
		//Cria o DAO
		CidadeDAO cidadeDao = new CidadeDAOImpl(em);
		//Busca as cidades
		System.out.println("LISTAR CIDADES");
		List<Cidade> lista = cidadeDao.listar();
		//Exibe o nome e o estado
		for (Cidade cidade : lista) {
			System.out.println(cidade.getNome() + " " +
					cidade.getUf());
		}
		
		System.out.println("BUSCAR POR NOME");
		lista = cidadeDao.buscarPorNome("Lon");
		for (Cidade cidade : lista) {
			System.out.println(cidade.getNome() + " " +
					cidade.getUf());
		}
		
		System.out.println("\n==========================================");
		
		PacoteDAO pacoteDAO = new PacoteDAOImpl(em);
		
		List<Pacote> listaPacotePorData = pacoteDAO.buscarPorDatas(new GregorianCalendar(2017, Calendar.JANUARY, 1), new GregorianCalendar(2017, Calendar.AUGUST, 1));
		
		for (Pacote pacote : listaPacotePorData) {
			System.out.println(pacote.getDescricao());
		}

		System.out.println("\n==========================================");
		
		ClienteDAO clienteDAO = new ClienteDAOImpl(em);
		
		for (Cliente cliente : clienteDAO.buscar("Leandro", "Londrina")) {
			System.out.println(cliente.getNome() + "\t" + cliente.getCpf());
		}
		
		System.out.println("\n==========================================");
		
		List<Cidade> cidadesPorEstados = cidadeDao.buscarPorEstados(Arrays.asList("SP", "BA"));
		
		for (Cidade cidade : cidadesPorEstados) {
			System.out.println(cidade.getNome());
		}

		System.out.println("\n===============================================================");
		System.out.println("\n===============================================================");
		//criar a reservadao
		ReservaDAO reservaDAO = new ReservaDAOImpl(em);
		
		System.out.println(reservaDAO.contarQuantidade());
		
		Calendar inicio = new GregorianCalendar(2015, Calendar.JANUARY, 1);
		Calendar fim = new GregorianCalendar(2018, Calendar.MAY, 2);
		
		long qtdPorData = reservaDAO.contarPorDatas(inicio, fim);
		
		System.out.println("Nesse periodo teve: " + qtdPorData);
		
		long qtdPorEstado = reservaDAO.contarPorEstadoCliente("PR");
		
		System.out.println("Por estado cliente: " + qtdPorEstado);

		List<Pacote> listaPacote = pacoteDAO.buscarPorDestino("al");
		
		for (Pacote pacote : listaPacote) {
			System.out.println("Destino do pacote: " + pacote.getDescricao());
		}

		long qtdTrasnporte = pacoteDAO.contarPorTrasnporte();
		
		System.out.println("Qtd por transporte (pacote): " + qtdTrasnporte);
		
		em.close();
		fabrica.close();
	}

}



