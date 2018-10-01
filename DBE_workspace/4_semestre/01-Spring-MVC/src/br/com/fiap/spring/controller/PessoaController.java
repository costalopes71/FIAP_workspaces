package br.com.fiap.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.spring.model.Pessoa;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

	@GetMapping("/cadastrar-pessoa")
	public String abrirTelaCadastro() {
		return "/pessoa/cadastro-pessoas";
	}
	
	@PostMapping("/cadastrar-pessoa")
	public String cadastrarPessoa(Pessoa pessoa) {
		System.out.println(pessoa.getNome() + ", " + pessoa.getIdade() + ", " + pessoa.isAposentado());
		return "/pessoa/cadastro-pessoas";
	}
	
}