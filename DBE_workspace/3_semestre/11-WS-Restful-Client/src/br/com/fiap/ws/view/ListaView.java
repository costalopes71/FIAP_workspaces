package br.com.fiap.ws.view;

import java.util.List;
import br.com.fiap.to.Selecao;
import br.com.fiap.ws.service.SelecaoService;

public class ListaView {

	public static void main(String[] args) {
		
		//instancia o service
		SelecaoService ss = new SelecaoService();

		List<Selecao> lista = null;
		try {
			//chama o WS
			lista = ss.listar();
			//exibe os resultados
			for (Selecao selecao : lista) {
				System.out.println(selecao.getPais());
				System.out.println("nº de mundiais: " + selecao.getNumeroMundiais());
				System.out.println("código: " + selecao.getCodigo());
				System.out.println("******************************************************");
			}
		} catch (Exception e) {
			System.out.println("erro");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
