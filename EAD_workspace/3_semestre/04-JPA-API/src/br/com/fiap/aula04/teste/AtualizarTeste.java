package br.com.fiap.aula04.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.aula04.entities.Carro;
import br.com.fiap.aula04.entities.TipoCarro;

public class AtualizarTeste {

	public static void main(String[] args) {
		
		Carro carro = new Carro("Gol", 2017, "DDD9090", TipoCarro.PASSEIO, new GregorianCalendar(2017, Calendar.JULY, 03), null);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = emf.createEntityManager();
		
		carro.setCodigo(1);
		
//		Carro carro = em.find(Carro.class, 1);		
//		carro.setModelo("Vectra");
//		as duas linhas de cima atualizam automaticamente o carro pois veio do banco, depois do commit sera gravado no banco
		
		em.getTransaction().begin();
		em.merge(carro);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
	}
	
	
}
