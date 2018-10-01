package br.com.fiap.ads.dbe.main;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.fiap.ads.dbe.bo.EstoqueBO;
import br.com.fiap.ads.dbe.bo.ProdutoNotFoundException;
import br.com.fiap.ads.dbe.singleton.PropertySingleton;
import br.com.fiap.ads.dbe.to.Produto;

public class TerminalConsulta {

	private static final Logger log = LoggerFactory.getLogger(TerminalConsulta.class);
	
	public static void main(String[] args) {
		
		log.info("Inicializando o sistema");
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		int opcao = 0;
		String logoEmpresa = null;
		EstoqueBO produtoBO = new EstoqueBO();
		DecimalFormat df = new DecimalFormat("R$ #,###.00");
		
		try {
			logoEmpresa = PropertySingleton.getInstance().getProperty("logo");
		} catch (IOException e) {
			System.out.println("Propriedade não encontrada no arquivo de propriedades.");
			e.printStackTrace();
		}
		
		do {
			Calendar cal = Calendar.getInstance();
			System.out.println(logoEmpresa + "\t\t\t\t" + sdf.format(cal.getTime()));
			System.out.println("*************************************************");
			System.out.println("[1] -> Pesquisar");
			System.out.println("[0] -> Sair");
			System.out.print("--> ");
			try {
				opcao = sc.nextInt();
			} catch (InputMismatchException e) {
				log.error(e.getMessage());
				System.out.println("Tipo incompatível. Digite apenas números.\n");
				sc.nextLine();
				continue;
			}
			
			if (opcao == 1) {
				System.out.print("Código do produto: ");
				Produto produto = null;
				try {
					produto = produtoBO.consultarProduto(sc.nextInt());
				} catch (ProdutoNotFoundException e) {
					log.warn("produto não encontrado");
					System.out.println(e.getMessage() + "\n");
					continue;
				} catch (Exception e) {
					log.error(e.getMessage());
					continue;
				}
				System.out.println("\nNome: " + produto.getNome());
				System.out.println("\nCódigo: " + produto.getCodigo());
				System.out.println("\nDescrição: " + produto.getDescricao());
				System.out.println("\nPreço: " + df.format(produto.getPreco()));
			} else if (opcao != 0) {
				System.out.println("Opção inválida.\n");
			}
		} while (opcao != 0);
		
		System.out.println("\nFIM.\nObrigado por usar.");
		sc.close();
		log.info("finalizando o sistema");
	}
	
}
