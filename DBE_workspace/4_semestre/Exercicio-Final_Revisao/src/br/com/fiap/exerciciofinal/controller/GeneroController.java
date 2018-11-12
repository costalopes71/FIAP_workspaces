package br.com.fiap.exerciciofinal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.exerciciofinal.dao.GeneroDAO;
import br.com.fiap.exerciciofinal.model.Genero;

@Controller
@RequestMapping(value = {"/genero", "", "/"})
public class GeneroController {

	@Autowired
	private GeneroDAO generoDAO;
	
	@GetMapping(value = {"/cadastrar-genero", "", "/"})
	public ModelAndView cadastrar(Genero genero) {
		return new ModelAndView("/genero/cadastrar-genero");
	}
	
	@PostMapping("/cadastrar-genero")
	@Transactional
	public ModelAndView cadastrar(@Valid Genero genero, BindingResult result, RedirectAttributes redirect) {
		ModelAndView model = new ModelAndView("redirect:/genero/cadastrar-genero");
		
		if (result.hasErrors()) {
			return cadastrar(genero);
		}
		
		try {
			generoDAO.cadastrar(genero);
			redirect.addFlashAttribute("msg", "Gênero cadastrado com sucesso!");
		} catch (Exception e) {
			redirect.addFlashAttribute("msg", "Erro ao tentar cadastrar o gênero!");
		}
		
		return model;
	}



}
