package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Cliente;

public class ConsoleView {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
		EntityManager em = emf.createEntityManager(); 
		CidadeDAO dao = new CidadeDAOImpl(em);
		ClienteDAOImpl daoCliente = new ClienteDAOImpl(em);
		
		List<Cidade> listaCidades = dao.listar();
		List<Cliente> listaCliente = daoCliente.listar(); 
		
		for (Cidade cidade : listaCidades) {
			System.out.println("Cidade: " + cidade.getNome() + "\tEstado: " + cidade.getUf());
		}
		
		List<Cidade> listaCidadesPorNome = dao.buscarPorNome("Sa");
		
		System.out.println("==================================================================\n");
		for (Cidade cidade : listaCidadesPorNome) {
			System.out.println("Nome: " + cidade.getNome() + "\tUF: " + cidade.getUf() + "\tNrº habitantes:: " + cidade.getNrHabitantes());
		}
		
		System.out.println("==================================================================\n");

		for (Cliente cliente : listaCliente) {
			System.out.println(cliente.getNome());
		}
		
		em.close();
		emf.close();
		
	}

}



