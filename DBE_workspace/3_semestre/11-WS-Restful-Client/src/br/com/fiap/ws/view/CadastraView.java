package br.com.fiap.ws.view;

import java.util.Scanner;
import br.com.fiap.to.Selecao;
import br.com.fiap.ws.service.SelecaoService;

public class CadastraView {

	public static void main(String[] args) {
		
		Selecao selecao = new Selecao();
		SelecaoService ss = new SelecaoService();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("País: ");
		selecao.setPais(sc.next() + sc.nextLine());
		
		System.out.print("Número de mundiais: ");
		selecao.setNumeroMundiais(sc.nextInt());
		
		System.out.print("Classificado: ");
		selecao.setClassificado(sc.nextBoolean());
		
		try {
			ss.cadastrar(selecao);
			System.out.println("Cadastrado com sucesso!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} finally {
			sc.close();
		}
		
	}
	
}
