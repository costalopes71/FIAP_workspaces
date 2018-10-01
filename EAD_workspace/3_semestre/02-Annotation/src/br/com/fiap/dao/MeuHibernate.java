package br.com.fiap.dao;

import br.com.fiap.annotation.Tabela;
import br.com.fiap.bean.Pessoa;

public class MeuHibernate {

	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa();
		System.out.println(persit(pessoa));
		
	}
	
	public static String persit(Pessoa pessoa) {
		//recuperar a anotacao
		Tabela anotacao = pessoa.getClass().getAnnotation(Tabela.class);
		String nomeDaTabela = anotacao.nome();
		String sql = "SELECT * FROM " + nomeDaTabela;
		return sql;
	}
	
}
