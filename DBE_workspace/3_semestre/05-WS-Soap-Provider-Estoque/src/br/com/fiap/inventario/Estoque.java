package br.com.fiap.inventario;

import java.util.ArrayList;
import java.util.List;

import org.apache.axis2.AxisFault;

import br.com.fiap.to.ProdutoTO;

/**
 * Classe respons�vel pelo WebService de tipos de produto.
 * @author Joao Lopes
 * @version 1.0
 * @since 21/02/2018
 */
public class Estoque {
	
	public List<ProdutoTO> listar() {
		List<ProdutoTO> lista = new ArrayList<>();
		lista.add(new ProdutoTO(401, "Camista Masculina", 50, "Branca"));
		lista.add(new ProdutoTO(402, "Camista Feminina", 100, "Rosa"));
		return lista;
	}
	
	/**
	 * M�todo respons�vel por retornar o produto pesquisado.
	 * @param String codProduto, uma string que representa o c�digo do produto a ser pesquisado.
	 * @return ProdutoTO produto, objeto produto com as informa��es do produto pesquisado.
	 * @throws AxisFault
	 */
	public ProdutoTO buscarProduto(String codProduto) throws AxisFault {

		ProdutoTO produto = null;
		int codigoProduto = Integer.parseInt(codProduto);
		switch (codigoProduto) {
		case 401:
			produto = new ProdutoTO(401, "Camisa masculina", 40.50, "Camisa branca");
			break;
		case 402:
			produto = new ProdutoTO(402, "Camisa feminina", 50.50, "Camisa rosa");
			break;
		default:
			throw new AxisFault("Produto n�o cadastrado");
		}
		return produto;
		
	}
	
}
