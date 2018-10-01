package br.com.fiap.aula04.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.aula04.entities.Carro;

public class RefreshTeste {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = emf.createEntityManager();
		
		Carro c = em.find(Carro.class, 1);
		c.setModelo("TESTE DO REFRESH");
		System.out.println("Modelo carro: " + c.getModelo());
		
		//o metodo REFRESH vai no banco e busca as informacoes que estao no banco para atualizar o OBJETO carro com as informacoes
		//que estao no banco. Ou seja, NAOOOO é um UPDATE pois nao serve para alterar o banco e sim para alterar o objeto com
		//as informacoes que estao no banco.
		em.refresh(c);
		System.out.println("Modelo carro: " + c.getModelo());

		em.close();
		emf.close();
	}
	
	
}
