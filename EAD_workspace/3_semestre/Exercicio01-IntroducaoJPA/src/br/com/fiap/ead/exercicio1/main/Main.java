package br.com.fiap.ead.exercicio1.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.ead.exercicio1.dao.impl.MotoristaDAOImpl;
import br.com.fiap.ead.exercicio1.dao.impl.VeiculoDAOImpl;
import br.com.fiap.ead.exercicio1.exceptions.CommitException;
import br.com.fiap.ead.exercicio1.exceptions.NoResultsException;

public class Main {

	public static void main(String[] args) {
		
//		Veiculo v = new Veiculo("DZB1291", "vermelho", 2001);
//		Motorista m = new Motorista(999333, "Joao Carlos", new GregorianCalendar(1987, Calendar.JULY, 24), null, Genero.MASCULINO);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = emf.createEntityManager();
		
		VeiculoDAOImpl veiculoDAO = new VeiculoDAOImpl(em);
		MotoristaDAOImpl motoristaDAO = new MotoristaDAOImpl(em);
		
		try {
			veiculoDAO.deletar(1);
			motoristaDAO.deletar(999333);
		} catch (NoResultsException e1) {
			System.err.println(e1.getMessage());
		}
		try {
			motoristaDAO.commit(em);
		} catch (CommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
