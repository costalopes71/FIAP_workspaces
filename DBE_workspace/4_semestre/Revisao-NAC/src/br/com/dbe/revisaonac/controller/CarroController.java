package br.com.dbe.revisaonac.controller;

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

import br.com.dbe.revisaonac.dao.CarroDAO;
import br.com.dbe.revisaonac.dao.MarcaDAO;
import br.com.dbe.revisaonac.model.Carro;

@Controller
@RequestMapping("carro")
public class CarroController {

	@Autowired
	private CarroDAO carroDAO;
	
	@Autowired
	private MarcaDAO marcaDAO;
	
	@GetMapping("cadastrar")
	public ModelAndView cadastrar(Carro carro) {
		return new ModelAndView("cadastro/cadastrar-carro").addObject("marcas", marcaDAO.listar());
	}
	
	@PostMapping("cadastrar")
	@Transactional
	public ModelAndView cadastrar(@Valid Carro carro, BindingResult bindingResults, RedirectAttributes redirectAttribute) {
		
		if (bindingResults.hasErrors()) {
			return cadastrar(carro);
		} else {
			try {
				carroDAO.inserir(carro);
				redirectAttribute.addFlashAttribute("msgSucesso", "Carro cadastrado com sucesso!");
			} catch (Exception e) {
				redirectAttribute.addFlashAttribute("msgErro", "Erro ao tentar cadastrar o carro!");
				e.printStackTrace();
			}
			return new ModelAndView("redirect:/carro/cadastrar");
		}
	}

	@GetMapping("listar")
	public ModelAndView listar() {
		return new ModelAndView("listar/listar-carros").addObject("carros", carroDAO.listar());
	}
	
}
