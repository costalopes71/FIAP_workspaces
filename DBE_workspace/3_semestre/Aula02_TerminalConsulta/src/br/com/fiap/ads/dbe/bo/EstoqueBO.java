package br.com.fiap.ads.dbe.bo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.fiap.ads.dbe.to.Produto;

public class EstoqueBO {

	private static final Logger log = LoggerFactory.getLogger(EstoqueBO.class);
	
	public Produto consultarProduto(int codProduto) throws ProdutoNotFoundException {
		log.debug("pesquisando um produto.");
		Produto produto = null;
		switch (codProduto) {
		case 401:
			produto = new Produto(401, "Camisa masculina", 40.50, "Camisa branca");
			break;
		case 402:
			produto = new Produto(402, "Camisa feminina", 50.50, "Camisa rosa");
			break;
		default:
			throw new ProdutoNotFoundException("Produto não encontrado.");
		}
		return produto;
	}
	
}
