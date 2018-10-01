package br.com.fiap.ws.view;

import java.util.Scanner;

import br.com.fiap.to.Selecao;
import br.com.fiap.ws.service.SelecaoService;

public class PesquisaView {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SelecaoService ss = new SelecaoService();
		
		System.out.print("C�digo da sele��o: ");
		int codigo = sc.nextInt();
		
		try {
			Selecao selecao = ss.pesquisar(codigo);
			System.out.println("C�digo: " + selecao.getCodigo());
			System.out.println("Pa�s: " + selecao.getPais());
			System.out.println("N� mundiais: " + selecao.getNumeroMundiais());
			System.out.println("Classificado: " + selecao.isClassificado());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			sc.close();
		}
		
	}
	
}
