package br.com.fiap.spring05mvcjpa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.fiap.spring05mvcjpa.dao.ConvidadoDAO;
import br.com.fiap.spring05mvcjpa.model.Convidado;

@Repository
public class ConvidadoDAOImpl extends GenericDAOImpl<Convidado, Integer> implements ConvidadoDAO {

	@Override
	public List<Convidado> listarEmOrdemAlfabetica() {
		return em.createQuery("FROM Convidado c ORDER BY c.nome", Convidado.class).getResultList();
	}

	@Override
	public void confirmar(int codigo) {
		Convidado convidado = pesquisar(codigo);
		convidado.setConfirmado(true);
		atualizar(convidado);
	}

	@Override
	public List<Convidado> pesquisarPor(String nome) {
		return em.createQuery("FROM Convidado c WHERE UPPER(c.nome) LIKE UPPER(:pNome)", Convidado.class).
				setParameter("pNome", "%" + nome + "%").getResultList();
	}
	
}
