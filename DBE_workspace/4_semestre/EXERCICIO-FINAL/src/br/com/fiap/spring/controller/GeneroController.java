package br.com.fiap.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.spring.dao.GeneroDAO;
import br.com.fiap.spring.model.Genero;

@Controller
@RequestMapping("/genero")
public class GeneroController {

	@Autowired
	private GeneroDAO generoDAO;
	
	@GetMapping("/cadastrar")
	public ModelAndView exibirFormularioCadastro() {
		return new ModelAndView("cadastrar/cadastrar-genero").addObject("genero", new Genero());
	}
	
	@PostMapping("/cadastrar")
	@Transactional
	public ModelAndView cadastrar(Genero genero, RedirectAttributes redirectAttribute) {
		ModelAndView model = new ModelAndView("redirect:/genero/cadastrar");
		
		try {
			generoDAO.cadastrar(genero);
			redirectAttribute.addFlashAttribute("msgSucesso", "Gênero cadastrado com sucesso.");
		} catch (Exception e) {
			redirectAttribute.addFlashAttribute("msgErro", "Erro ao tentar cadastrar o gênero.");
		}
		
		return model;
	}
	
}
