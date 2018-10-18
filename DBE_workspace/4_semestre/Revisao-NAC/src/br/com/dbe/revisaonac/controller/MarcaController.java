package br.com.dbe.revisaonac.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.dbe.revisaonac.dao.MarcaDAO;
import br.com.dbe.revisaonac.model.Marca;

@Controller
@RequestMapping("marca")
public class MarcaController {

	@Autowired
	private MarcaDAO marcaDAO;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Marca marca) {
		return "cadastro/cadastrar-marca";
	}
	
	@PostMapping("/cadastrar")
	@Transactional
	public String cadastrar(@Valid Marca marca, BindingResult bindingResult, RedirectAttributes redirectAttribute) {
		
		if (bindingResult.hasErrors()) {
			return "cadastro/cadastrar-marca";
		} else {
			try {
				marcaDAO.inserir(marca);
				redirectAttribute.addFlashAttribute("msgSucesso", "Marca cadastrada com sucesso!");
			} catch (Exception e) {
				redirectAttribute.addFlashAttribute("msgErro", "Erro ao tentar cadastrar a marca!");
				e.printStackTrace();
			}
		}
		
		
		return "redirect:/marca/cadastrar";
	}
	
}
