package br.com.fiap.ead.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.ead.dao.ConsultaDAO;
import br.com.fiap.ead.dao.impl.ConsultaDAOImpl;
import br.com.fiap.ead.entities.Consulta;
import br.com.fiap.ead.entities.Especialidade;
import br.com.fiap.ead.entities.Medico;
import br.com.fiap.ead.entities.Paciente;
import br.com.fiap.ead.exception.CommitException;
import br.com.fiap.ead.singleton.EntityManagerFactorySingleton;

public class ChaveCompostaTeste {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance(); 
		EntityManager em = emf.createEntityManager();
		
		//cadastrar o medico, paciente e a consulta
		
		Medico medico2 = new Medico(123, "Drauzio", Especialidade.GINECOLOGISTA, 12000.50, 35188);
		
		Medico medico = new Medico(123456, "Natanael Britto", Especialidade.CIRURGIAO);
		Paciente paciente = new Paciente("Camila Forte Maravilha", new GregorianCalendar(1988, Calendar.AUGUST, 22));
		Consulta consulta = new Consulta(medico, paciente, Calendar.getInstance(), "Consultorio 1", true);
		
		Paciente paciente2 = new Paciente("Bruna Castaldi", new GregorianCalendar(1999, Calendar.AUGUST, 30));
		Consulta consulta2 = new Consulta(medico2, paciente2, Calendar.getInstance(), "Consultorio 9", true);
		
		ConsultaDAO dao = new ConsultaDAOImpl(em);
		try {
//			dao.inserir(consulta);
			dao.inserir(consulta2);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		em.close();
		
	}
	
}
