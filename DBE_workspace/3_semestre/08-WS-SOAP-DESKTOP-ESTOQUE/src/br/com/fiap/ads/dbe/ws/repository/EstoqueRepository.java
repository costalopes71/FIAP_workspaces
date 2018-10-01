package br.com.fiap.ads.dbe.ws.repository;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import br.com.fiap.inventario.EstoqueStub;
import br.com.fiap.inventario.EstoqueStub.BuscarProduto;
import br.com.fiap.inventario.EstoqueStub.BuscarProdutoResponse;
import br.com.fiap.inventario.EstoqueStub.ProdutoTO;

public class EstoqueRepository {

	private EstoqueStub stub;

	public EstoqueRepository() throws AxisFault {
		stub = new EstoqueStub();
	}
	
	public ProdutoTO buscarProduto(int codigo) throws RemoteException {
		
		BuscarProduto params = new BuscarProduto();
		params.setCodProduto(String.valueOf(codigo));
		
		BuscarProdutoResponse resposta = stub.buscarProduto(params);
		
		return resposta.get_return();
	}
	
}
