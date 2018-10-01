package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.GenericDAO;
import br.com.fiap.exceptions.CommitException;
import br.com.fiap.exceptions.IdNotFoundException;

public class GenericDAOImpl<T, K> implements GenericDAO<T, K> {

	private EntityManager em;
	private Class<T> classe;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl() {
		em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		classe = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public List<T> listar() {
		return em.createQuery("FROM " + classe.getName(), classe).getResultList();
	}

	@Override
	public void cadastrar(T entity) {
		em.persist(entity);
	}

	@Override
	public T pesquisar(K codigo) {
		return em.find(classe, codigo);
	}

	@Override
	public void atualizar(T entity) {
		em.merge(entity);
	}

	@Override
	public void deletar(K codigo) throws IdNotFoundException {
		T entity = pesquisar(codigo);
		if (entity == null) {
			throw new IdNotFoundException("Código não localizado.");
		}
		em.remove(entity);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
			throw new CommitException("Erro ao tentar gravar.");
		}
		
	}

}
