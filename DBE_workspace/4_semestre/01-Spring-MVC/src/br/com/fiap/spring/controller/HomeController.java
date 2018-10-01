package br.com.fiap.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	//Metodo que atende uma requisicao
	@RequestMapping("/home")
	public String home() {
		//Retorna a view (pasta e arquivo)
		return "/home/index";
	}

}