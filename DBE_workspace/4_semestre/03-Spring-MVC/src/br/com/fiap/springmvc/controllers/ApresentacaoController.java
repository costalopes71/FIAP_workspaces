package br.com.fiap.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.springmvc.model.Apresentacao;

@Controller
@RequestMapping("apresentacao")
public class ApresentacaoController {

	@GetMapping("cadastrar-apresentacao")
	public String abrirApresentacaoCadastrar() {
		return "/apresentacao/cadastrar-apresentacao";
	}
	
	@PostMapping("cadastrar-apresentacao")
	public ModelAndView cadastrarApresentacao(Apresentacao apresentacao) {
		return new ModelAndView("/apresentacao/cadastrar-apresentacao").addObject("msg", "Apresentação agendada!");
	}
	
}
