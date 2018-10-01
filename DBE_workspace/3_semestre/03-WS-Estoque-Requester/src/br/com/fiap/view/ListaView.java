package br.com.fiap.view;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import org.apache.axis2.AxisFault;

import br.com.fiap.inventario.EstoqueStub;
import br.com.fiap.inventario.EstoqueStub.Listar;
import br.com.fiap.inventario.EstoqueStub.ListarResponse;
import br.com.fiap.inventario.EstoqueStub.ProdutoTO;

public class ListaView {

	public static void main(String[] args) {
		
		EstoqueStub stub = null;
		try {
			stub = new EstoqueStub();
		} catch (AxisFault e) {
			e.printStackTrace();
		}
		
		Listar params = new Listar();
		
		ListarResponse resposta = null;
		
		try {
			resposta = stub.listar(params);
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
		}
		
		List<ProdutoTO> listaProdutos = Arrays.asList(resposta.get_return());
		
		for (ProdutoTO produtoTO : listaProdutos) {
			System.out.println(produtoTO.getCodigo());
			System.out.println(produtoTO.getNome());
			System.out.println(produtoTO.getDescricao());
			System.out.println(produtoTO.getPreco());
			System.out.println("****************************");
		}
		
	}
	
}
