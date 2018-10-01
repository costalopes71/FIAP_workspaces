package br.com.fiap.springjpa.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.fiap.springjpa.dao.ProdutoDAO;
import br.com.fiap.springjpa.model.Produto;

@Repository
public class ProdutoDAOImpl extends GenericDAOImpl<Produto, Integer> implements ProdutoDAO {

}
