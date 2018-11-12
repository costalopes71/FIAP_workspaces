package br.com.fiap.exerciciofinal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.exerciciofinal.dao.GeneroDAO;
import br.com.fiap.exerciciofinal.dao.JogoDAO;
import br.com.fiap.exerciciofinal.model.Jogo;
import br.com.fiap.exerciciofinal.model.Plataforma;

@Controller
@RequestMapping("/jogo")
public class JogoController {

	@Autowired
	private JogoDAO jogoDAO;
	
	@Autowired
	private GeneroDAO generoDAO;
	
	@GetMapping("/cadastrar-jogo")
	public ModelAndView cadastrar(Jogo jogo) {
		ModelAndView model = new ModelAndView("jogo/cadastrar-jogo"); 
		
		model.addObject("plataformas", Plataforma.values());
		try {
			model.addObject("generos", generoDAO.listar());
		} catch (Exception e) {
			model.addObject("msg", "Erro ao tentar recuperar os gêneros cadastrados no banco de dados.");
		}
		
		return model;
	}
	
	@PostMapping("/cadastrar-jogo")
	@Transactional
	public ModelAndView cadastrar(@Valid Jogo jogo, BindingResult results, RedirectAttributes redirect) {
		ModelAndView model = new ModelAndView("redirect:/jogo/cadastrar-jogo");
		
		if (results.hasErrors()) {
			return cadastrar(jogo);
		}
		
		jogo.setDisponivel(false);
		
		try {
			jogoDAO.cadastrar(jogo);
			redirect.addFlashAttribute("msg", "Jogo cadastrado com sucesso!");
		} catch (Exception e) {
			redirect.addFlashAttribute("msg", "Erro ao tentar cadastrar o jogo!");
		}
		
		return model;
	}
	
	@GetMapping("/listar-jogos")
	public ModelAndView listar() {
		ModelAndView model = new ModelAndView("/jogo/listar-jogos");
		
		try {
			model.addObject("jogos", jogoDAO.listar());
			model.addObject("generos", generoDAO.listar());
		} catch (Exception e) {
			model.addObject("msg", "Erro ao tentar recuperar os jogos do banco de dados.");
		}
		
		return model;
	}
	
	@GetMapping("/editar-jogo/{codigo}")
	public ModelAndView editar(@PathVariable("codigo") int codigo) {
		ModelAndView model = new ModelAndView("/jogo/editar-jogo");
		
		try {
			model.addObject("jogo", jogoDAO.buscar(codigo));
			model.addObject("generos", generoDAO.listar());
			model.addObject("plataformas", Plataforma.values());
		} catch (Exception e) {
			model.addObject("msg", "Erro ao buscar o jogo no banco de dados.");
		}
		return model;
	}
	
	@PostMapping("/editar-jogo")
	@Transactional
	public ModelAndView editar(@Valid Jogo jogo, BindingResult results, RedirectAttributes redirect) {
		
		if (results.hasErrors()) {
			return new ModelAndView("/jogo/editar-jogo")
					.addObject("jogo", jogo)
					.addObject("generos", generoDAO.listar())
					.addObject("plataformas", Plataforma.values());
		}
		
		try {
			jogoDAO.atualizar(jogo);
			redirect.addFlashAttribute("msg", "Jogo atualizado com sucesso!");
		} catch (Exception e) {
			redirect.addFlashAttribute("msg", "Erro ao tentar atualizar o jogo!");
		}
		
		return new ModelAndView("redirect:/jogo/listar-jogos");
	}
	
	@PostMapping("/remover-jogo")
	@Transactional
	public ModelAndView remover(int codigo, RedirectAttributes redirect) {
		ModelAndView model = new ModelAndView("redirect:/jogo/listar-jogos");
		
		try {
			jogoDAO.excluir(codigo);
			redirect.addFlashAttribute("msg", "Jogo removido com sucesso!");
		} catch (Exception e) {
			redirect.addFlashAttribute("msg", "Erro ao tentar remover o jogo!");
		}
		
		return model;
	}
	
	@PostMapping("/disponibilizar-jogo")
	@Transactional
	public ModelAndView disponibilizar(int codigo, RedirectAttributes redirect) {
		ModelAndView model = new ModelAndView("redirect:/jogo/listar-jogos");
		
		Jogo jogo = jogoDAO.buscar(codigo);
		jogo.setDisponivel(true);
		try {
			jogoDAO.atualizar(jogo);
			redirect.addFlashAttribute("msg", "Jogo disponibilizado com sucesso!");
		} catch (Exception e) {
			redirect.addFlashAttribute("msg", "Erro ao tentar disponibilizar o jogo!");
		}
		
		return model;
	}
	
	@GetMapping("/pesquisarPorNome")
	public ModelAndView pesquisarPorNome(String pesquisa) {
		ModelAndView model = new ModelAndView("/jogo/listar-jogos");
		
		try {
			model.addObject("jogos", jogoDAO.buscarPorNome(pesquisa));
			model.addObject("generos", generoDAO.listar());
		} catch (Exception e) {
			model.addObject("msg", "Erro ao tentar pesquisar os jogos no banco de dados.");
		}
		return model;
	}
	
	@GetMapping("/pesquisarPorGenero")
	public ModelAndView pesquisarPorGenero(int codigo) {
		ModelAndView model = new ModelAndView("/jogo/listar-jogos");
		
		try {
			model.addObject("jogos", jogoDAO.buscarPorGenero(codigo));
			model.addObject("generos", generoDAO.listar());
		} catch (Exception e) {
			model.addObject("msg", "Erro ao tentar pesquisar os jogos no banco de dados.");
		}
		return model;
		
	}
	
}





