package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.fiap.jpa.entity.Aluno;
import br.com.fiap.jpa.entity.Curso;
import br.com.fiap.jpa.entity.Periodo;
import br.com.fiap.jpa.entity.StatusCurso;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = emf.createEntityManager();
		
		Aluno aluno = new Aluno("Joao Carlos", "ADS", new GregorianCalendar(1987, Calendar.JULY, 24), true, Periodo.NOTURNO, 3, null, null);
		Curso curso = new Curso("Análise e Desenvolvimento de Sistema", StatusCurso.ATIVO, 4, 
				new GregorianCalendar(1994, Calendar.JANUARY, 01) , null);
		//persistindo o aluno
		em.getTransaction().begin(); //como o auto commit nao esta habilitado, devemos iniciar uma transacao e depois comita-la.
		em.persist(aluno);
		em.persist(curso);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
	}

}
