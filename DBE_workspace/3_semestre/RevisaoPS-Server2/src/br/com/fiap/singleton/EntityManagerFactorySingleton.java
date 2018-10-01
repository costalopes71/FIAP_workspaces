package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

	private static EntityManagerFactory instance;
	
	private EntityManagerFactorySingleton() { 
		
	}
	
	public static EntityManagerFactory getInstance() {
		if (instance == null) {
			instance = Persistence.createEntityManagerFactory("oracle2");
		}
		return instance;
	}
	
}
