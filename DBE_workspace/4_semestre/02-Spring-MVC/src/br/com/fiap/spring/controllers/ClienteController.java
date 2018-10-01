package br.com.fiap.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.spring.model.Cliente;

@Controller
@RequestMapping("cliente")
public class ClienteController {

	@GetMapping("cadastrar")
	public String abrirCadastro() {
		
		return "cliente/form"; // pasta + pagina
	}
	
	@PostMapping("cadastrar")
	public String cadastrar(Cliente cliente) {
		System.out.println(cliente.getNome());
		System.out.println(cliente.getIdade());
		System.out.println(cliente.isCnh());
		System.out.println(cliente.getGenero());
		ModelAndView retorno = new ModelAndView("cliente/sucesso");
		retorno.addObject("cli", cliente);
		retorno.addObject("mensagem", "cliente cadastrado");
		return "cliente/sucesso";
	}
	
}
