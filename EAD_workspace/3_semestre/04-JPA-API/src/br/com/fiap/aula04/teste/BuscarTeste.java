package br.com.fiap.aula04.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.aula04.entities.Carro;

public class BuscarTeste {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = emf.createEntityManager();
		
		Carro c = em.find(Carro.class, 1);
		
		em.close();
		emf.close();
		
		System.out.println(c.getModelo());
		
		
		
	}
	
}
