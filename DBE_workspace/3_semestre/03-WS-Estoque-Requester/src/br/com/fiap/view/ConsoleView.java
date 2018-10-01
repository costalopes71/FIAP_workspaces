package br.com.fiap.view;

import java.rmi.RemoteException;
import java.util.Scanner;
import org.apache.axis2.AxisFault;
import br.com.fiap.inventario.EstoqueStub;
import br.com.fiap.inventario.EstoqueStub.BuscarProduto;
import br.com.fiap.inventario.EstoqueStub.BuscarProdutoResponse;
import br.com.fiap.inventario.EstoqueStub.ProdutoTO;

public class ConsoleView {

	public static void main(String[] args) throws AxisFault {
		
		EstoqueStub stub = new EstoqueStub();
		Scanner sc = new Scanner(System.in);
		//setando os parametros para a pesquisa
		BuscarProduto params = new BuscarProduto();
		
		//solicitando ao usuario os parametros
		System.out.print("Digite o c�digo do produto: ");
		params.setCodProduto(sc.next() + sc.nextLine());
		
		//pesquisando no WS
		BuscarProdutoResponse response = null;
		try {
			response = stub.buscarProduto(params);
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		ProdutoTO produtoTO = response.get_return();
		
		System.out.println("C�digo do produto: " + produtoTO.getCodigo());
		System.out.println("C�digo do nome: " + produtoTO.getNome());
		System.out.println("C�digo do descri�ao: " + produtoTO.getDescricao());
		System.out.println("Pre�o do produto: " + produtoTO.getPreco());
		
		sc.close();
	}
	
}
