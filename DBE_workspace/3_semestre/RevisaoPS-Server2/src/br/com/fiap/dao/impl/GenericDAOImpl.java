package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import br.com.fiap.dao.GenericDAO;
import br.com.fiap.exceptions.CommitException;
import br.com.fiap.exceptions.IdNotFoundException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class GenericDAOImpl<T, K> implements GenericDAO<T, K> {

	private EntityManager em;
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl() {
		em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public void cadastrar(T entity) {
		em.persist(entity);
	}

	@Override
	public T pesquisar(K id) {
		return em.find(clazz, id);
	}

	@Override
	public List<T> listar() {
		return em.createQuery("FROM " + clazz.getName(), clazz).getResultList();
	}

	@Override
	public void atualizar(T entity) {
		em.merge(entity);
	}

	@Override
	public void deletar(K id) throws IdNotFoundException {
		T entity = this.pesquisar(id);
		if (entity == null) {
			throw new IdNotFoundException("Codigo nao localizado.");
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
			throw new CommitException("Erro interno ao tentar cadastrar.");
		}
	}

}
