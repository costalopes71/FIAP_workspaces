package br.com.fiap.ddd.ead.aula06.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.ddd.ead.aula06.dao.AlunoDAO;
import br.com.fiap.ddd.ead.aula06.dao.LivroDAO;
import br.com.fiap.ddd.ead.aula06.daoImpl.AlunoDAOImpl;
import br.com.fiap.ddd.ead.aula06.daoImpl.LivroDAOImpl;
import br.com.fiap.ddd.ead.aula06.entity.Livro;
import br.com.fiap.ddd.ead.aula06.expeption.CommitExption;
import br.com.fiap.ddd.ead.aula06.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();

		//CADASTRAR
		Livro l = new Livro("Elogio a Loucura", "Erasmo de Roterdã");
//		Aluno a = new Aluno("78573", "João Carlos Costa Lopes");
		
		AlunoDAO dao = new AlunoDAOImpl(em);
		LivroDAO dao2 = new LivroDAOImpl(em);
		
		try {
//			dao.inserir(a);
			dao2.inserir(l);
			dao.commit();
		} catch (CommitExption e) {
			System.out.println(e.getMessage());
		}
		
		
		
		em.close();
		fabrica.close();
		
	}
}
