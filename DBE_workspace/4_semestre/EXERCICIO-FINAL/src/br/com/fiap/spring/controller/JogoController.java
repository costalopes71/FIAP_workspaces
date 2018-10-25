package br.com.fiap.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.spring.dao.GeneroDAO;
import br.com.fiap.spring.dao.JogoDAO;
import br.com.fiap.spring.model.Jogo;
import br.com.fiap.spring.model.Plataforma;

@Controller
@RequestMapping("/jogo")
public class JogoController {

	@Autowired
	private JogoDAO jogoDAO;
	
	@Autowired
	private GeneroDAO generoDAO;
	
	@GetMapping("/cadastrar")
	public ModelAndView exibirFormularioCadastro(Jogo jogo) {
		ModelAndView model = new ModelAndView("cadastrar/cadastrar-jogo");
		
		try {
			model.addObject("generos", generoDAO.listar());
			model.addObject("plataformas", Plataforma.values());
		} catch (Exception e) {
			model.addObject("msgErro", "Erro ao tentar carregar os gêneros.");
		}
		
		return model;
	}
	
	@PostMapping("/cadastrar")
	@Transactional
	public ModelAndView cadastrar(@Valid Jogo jogo, BindingResult results, RedirectAttributes redirectAttribute) {
		ModelAndView model = new ModelAndView("redirect:/jogo/cadastrar");

		if (results.hasErrors()) {
			return exibirFormularioCadastro(jogo);
		}
		
		
		jogo.setDisponivel(false);
		try {
			jogoDAO.cadastrar(jogo);
			redirectAttribute.addFlashAttribute("msgSucesso", "Jogo cadastrado com sucesso.");
		} catch (Exception e) {
			redirectAttribute.addFlashAttribute("msgErro", "Erro ao tentar cadastrar o jogo.");
		}
		return model;
	}
	
}
