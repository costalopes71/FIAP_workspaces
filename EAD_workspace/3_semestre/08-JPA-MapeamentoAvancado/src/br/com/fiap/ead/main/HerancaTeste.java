package br.com.fiap.ead.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.ead.dao.PessoaDAO;
import br.com.fiap.ead.dao.impl.PessoaDAOImpl;
import br.com.fiap.ead.entities.Pessoa;
import br.com.fiap.ead.entities.PessoaFisica;
import br.com.fiap.ead.entities.PessoaJuridica;
import br.com.fiap.ead.exception.CommitException;
import br.com.fiap.ead.singleton.EntityManagerFactorySingleton;

public class HerancaTeste {

	public static void main(String[] args) {

		EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
		EntityManager em = emf.createEntityManager();
		PessoaDAO dao = new PessoaDAOImpl(em);
		
		//cadastrar uma pessoa, PF e PJ
		Pessoa pessoa = new Pessoa("Thiago Roger", "Rua Maria Paula, 394 - Centro");
		PessoaFisica pessoa1 = new PessoaFisica("357.364.058-30", "35.188.062-8", "João Carlos Costa Lopes", "Rua Ilansa, 3400 - Mooca");
		PessoaJuridica pessoa2 = new PessoaJuridica("Telhas e Telhados LTDA", "Av. Santa Catarina, 1293 - Vila Antonieta", "000.1455.9987-565", "Telhanorte");
		
		try {
			dao.inserir(pessoa);
			dao.inserir(pessoa1);
			dao.inserir(pessoa2);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		em.close();
		emf.close();
		
	}
	
	
}
