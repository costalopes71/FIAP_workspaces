package br.com.fiap.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contato")
public class ContatoController {

	//@RequestMapping("/contato/enviar") --> maneira mais verbosa
	@GetMapping("/contato/enviar")
	public String abrirContato() {
		return "contato/form";
	}
	
	//Metodo que recupera as informacoes do formulario
	//@RequestMapping(value="/contato/enviar", method=RequestMethod.POST) --> maneira mais verbosa
	@PostMapping("/enviar")
	public String processaContato(String nome, String mensagem) {
		System.out.println(nome + " " + mensagem);
		return "contato/form";
	}
	
}
