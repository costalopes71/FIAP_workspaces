package br.com.fiap.aula04.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.com.fiap.aula04.entities.Carro;
import br.com.fiap.aula04.entities.TipoCarro;
import br.com.fiap.aula4.dao.CarroDAO;
import br.com.fiap.aula4.dao.impl.CarroDAOImpl;
import br.com.fiap.aula4.exceptions.CarNotFoundException;
import br.com.fiap.aula4.exceptions.CommitException;

public class DaoTeste {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = emf.createEntityManager();
		
		CarroDAO dao = new CarroDAOImpl(em);
		
		Carro carro = new Carro("Monza", 1994, "DDD1111", TipoCarro.PASSEIO, new GregorianCalendar(1994, Calendar.SEPTEMBER, 
				11), null);
		
		dao.create(carro);
		
		try {
			dao.commit();
		} catch (CommitException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		//BUSCA
		Carro carroBusca = dao.find(carro.getCodigo());
		System.out.println(carroBusca.getModelo());
		
		//ATUALIZACAO
		carroBusca.setModelo("Vectra");
		
		try {
			dao.update(carroBusca);
			dao.commit();
		} catch (CommitException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		//REMOCAO
		try {
			dao.delete(carroBusca.getCodigo());
			dao.commit();
		} catch (CarNotFoundException | CommitException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		em.close();
		emf.close();
		
	}
	
}
