package br.com.dbe.revisaonac.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.dbe.revisaonac.dao.CarroDAO;
import br.com.dbe.revisaonac.model.Carro;

@Repository
public class CarroDAOImpl extends GenericDAOImpl<Carro, Integer> implements CarroDAO {

}
