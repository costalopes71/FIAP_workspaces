package br.com.fiap.teste;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.com.fiap.annotation.Coluna;
import br.com.fiap.bean.Pessoa;

public class AnotacaoTeste {

	public static void main(String[] args) {
		
		Pessoa pessoa = new Pessoa();
		
		System.out.println("==========================================================");
		System.out.println("Pegando o nome completo da classe e o nome simplificado da classe");
		//API Reflection
		System.out.println(pessoa.getClass());
		System.out.println(pessoa.getClass().getName());

		System.out.println("==========================================================");
		System.out.println("Pegando os atributos e as annotations que existem neles");
		Field[] attrs = pessoa.getClass().getDeclaredFields();
		Method[] metodos = pessoa.getClass().getDeclaredMethods();
		
		for (Field attr : attrs) {
			System.out.println(attr.getName());
			Coluna anotacao = attr.getAnnotation(Coluna.class);
			if (anotacao != null) {
				System.out.println("Nome da anotacao: " + anotacao.nome());
			}
		}
		
		System.out.println("==========================================================");
		System.out.println("Pegando os metodos declarados da classe:");
		for (Method method : metodos) {
			System.out.println(method.getName() + "\tModificador de acesso: " + method.getModifiers());
		}

	}
	
}
