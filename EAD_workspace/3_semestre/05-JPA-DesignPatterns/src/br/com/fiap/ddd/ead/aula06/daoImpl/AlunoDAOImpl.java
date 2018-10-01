package br.com.fiap.ddd.ead.aula06.daoImpl;

import javax.persistence.EntityManager;

import br.com.fiap.ddd.ead.aula06.dao.AlunoDAO;
import br.com.fiap.ddd.ead.aula06.entity.Aluno;

public class AlunoDAOImpl extends GenericDAOImpl<Aluno, String> implements AlunoDAO {

	public AlunoDAOImpl(EntityManager em) {
		super(em);
	}

}
