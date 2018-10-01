package br.com.fiap.nac.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.nac.entities.Locacao;

public interface LocacaoDAO extends GenericDAO<Locacao, Integer>{

	//Buscar todas as locações que possuem a data de inicio entre duas datas.
	List<Locacao> buscarLocacaoPorData(Calendar inicio, Calendar fim);
	long quantidadeDeLocacoesPorCliente(int codigoCliente);
	
}
