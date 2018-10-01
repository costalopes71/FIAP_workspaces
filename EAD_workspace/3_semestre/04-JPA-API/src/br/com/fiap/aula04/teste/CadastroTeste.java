package br.com.fiap.aula04.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.fiap.aula04.entities.Carro;
import br.com.fiap.aula04.entities.TipoCarro;

public class CadastroTeste {

	public static void main(String[] args) {
		
		Carro carro = new Carro("Corsa", 2015, "AAA1234", TipoCarro.PASSEIO, new GregorianCalendar(2015, Calendar.JANUARY, 01), null);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(carro);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
	}
	
}
