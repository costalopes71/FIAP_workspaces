package br.com.fiap.ws.view;

import java.util.Scanner;

import br.com.fiap.ws.service.SelecaoService;

public class DeletaView {

	public static void main(String[] args) {
		
		SelecaoService ss = new SelecaoService();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("DELETAR");
		System.out.println("Código: ");
		
		try {
			ss.deletar(sc.nextInt());
			System.out.println("DELETADO COM SUCESSO!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			sc.close();
		}
		
	}
	
}
