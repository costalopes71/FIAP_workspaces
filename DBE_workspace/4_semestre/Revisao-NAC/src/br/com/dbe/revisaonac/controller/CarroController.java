package br.com.dbe.revisaonac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.dbe.revisaonac.model.Carro;

@Controller
@RequestMapping("carro")
public class CarroController {

	@GetMapping("cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView model = new ModelAndView("cadastro/cadastrar-carro");
		model.addObject("carro", new Carro());
		return model;
	}
	
}
