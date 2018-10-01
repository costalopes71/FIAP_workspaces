package br.com.fiap.aula04.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.aula04.entities.Carro;

public class RemoveTeste {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Carro carro = em.find(Carro.class, 1);
		
		em.remove(carro);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
}
