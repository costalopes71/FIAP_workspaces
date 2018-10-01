package br.com.fiap.dao;

import java.util.Calendar;

import br.com.fiap.entity.Reserva;

public interface ReservaDAO extends GenericDAO<Reserva,Integer>{

	long contarQuantidade();
	long quantidadeReservaPorCliente(int codigoCliente);
	// Contar a qtd por um determinado periodo
	// NamedQuery
	long contarPorDatas(Calendar inicio, Calendar fim);
	// Contar a quantidade de reserva por estado do cliente (NamedQuery)
	long contarPorEstadoCliente(String uf);
	
}
