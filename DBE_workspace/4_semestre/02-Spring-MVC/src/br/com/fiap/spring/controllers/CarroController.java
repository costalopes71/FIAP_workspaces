package br.com.fiap.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.spring.model.Carro;

@Controller
@RequestMapping("carro")
public class CarroController {

	@GetMapping("cadastrar")
	public String abrirTelaCadastro() {
		return "/carro/form-cadastro-carro";
	}
	
	@PostMapping("cadastrar")
	public ModelAndView cadastrar(Carro carro) {
		ModelAndView model = new ModelAndView("carro/sucesso");
		model.addObject("carro", carro);
		System.out.println(carro.getModelo());
		System.out.println(carro.getMarca());
		System.out.println(carro.getAno());
		System.out.println(carro.getCambio());
		System.out.println(carro.isNovo());
		return model;
	}
	
}
