package br.com.dbe.revisaonac.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.dbe.revisaonac.dao.MarcaDAO;
import br.com.dbe.revisaonac.model.Marca;

@Repository
public class MarcaDAOImpl extends GenericDAOImpl<Marca, Integer> implements MarcaDAO {

}
