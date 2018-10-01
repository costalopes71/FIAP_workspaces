package br.com.fiap.ads.main;

import java.io.IOException;

import br.com.fiap.ads.singleton.PropertiesSingleton;

public class Teste {

	public static void main(String[] args) throws IOException {
		
		String banco = PropertiesSingleton.getInstance().getProperty("banco");
		System.out.println(banco);
	}
	
}
