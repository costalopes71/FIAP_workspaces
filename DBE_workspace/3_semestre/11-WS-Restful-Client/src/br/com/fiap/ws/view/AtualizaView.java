package br.com.fiap.ws.view;

import java.util.Scanner;

import br.com.fiap.to.Selecao;
import br.com.fiap.ws.service.SelecaoService;

public class AtualizaView {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SelecaoService ss = new SelecaoService();
		Selecao selecao = new Selecao();
		Integer codigo;
		
		System.out.println("*****************************\nATUALIZAR\n*****************************");
		System.out.print("Código da seleção: ");
		codigo = sc.nextInt();
		
		try {
			selecao = ss.pesquisar(codigo);
		} catch (Exception e1) {
			System.err.println(e1.getMessage());
			System.exit(1);
		}
		
		System.out.print("País seleção: ");
		selecao.setPais(sc.next() + sc.nextLine());
		System.out.print("Número de mundiais: ");
		selecao.setNumeroMundiais(sc.nextInt());
		System.out.print("Classificado: ");
		selecao.setClassificado(sc.nextBoolean());	
		
		try {
			ss.atualizar(selecao);
			System.out.println("Atualizado com sucesso!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} finally {
			sc.close();
		}
		
	}
	
}
