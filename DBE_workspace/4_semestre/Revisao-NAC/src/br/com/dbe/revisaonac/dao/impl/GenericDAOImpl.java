package br.com.dbe.revisaonac.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.dbe.revisaonac.dao.GenericDAO;
import br.com.dbe.revisaonac.exceptions.KeyNotFoundException;

public class GenericDAOImpl<T,K> implements GenericDAO<T, K> {

	// o framework ira gerenciar os EntityManager (criar e destruir)
	@PersistenceContext
	private EntityManager em;
	
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl() {
		clazz = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public void inserir(T entidade) {
		em.persist(entidade);
	}

	@Override
	public void atualizar(T entidade) {
		em.merge(entidade);
	}

	@Override
	public void remover(K codigo) throws KeyNotFoundException {
		T entidade = pesquisar(codigo);
		if (entidade == null) {
			throw new KeyNotFoundException();
		}
		em.remove(entidade);
	}

	@Override
	public T pesquisar(K codigo) {
		return em.find(clazz, codigo);
	}
	
	@Override
	public List<T> listar() {
		return em.createQuery("from "+ clazz.getName(), clazz).getResultList();
	}
	
}