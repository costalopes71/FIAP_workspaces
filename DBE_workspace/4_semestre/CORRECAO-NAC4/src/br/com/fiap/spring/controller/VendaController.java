package br.com.fiap.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.spring.dao.VendaDAO;
import br.com.fiap.spring.model.Venda;

@Controller
@RequestMapping("venda")
public class VendaController {

	@Autowired
	private VendaDAO vendaDAO;
	
	@GetMapping("cadastrar")
	public String cadastrar(Venda venda) {
		return "venda/cadastrar-venda";
	}
	
	@PostMapping("cadastrar")
	@Transactional
	public String cadastrar(Venda venda, RedirectAttributes redirectAttributes) {
		
		try {
			vendaDAO.cadastrar(venda);
			redirectAttributes.addFlashAttribute("msgSucesso", "Venda cadastrada com sucesso!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("msgErro", "Erro ao tentar cadastrar a venda!");
		}
		
		return "redirect:/venda/cadastrar";
	}
	
	@GetMapping("listar")
	public ModelAndView listar() {
		return new ModelAndView("venda/listar").addObject("vendas", vendaDAO.listar()); 
	}
	
	@GetMapping("pesquisar")
	public ModelAndView pesquisar(String pesquisa) {
		return new ModelAndView("venda/listar").addObject("vendas", vendaDAO.buscarPorCliente(pesquisa));
	}
	
	@PostMapping("pagar")
	@Transactional
	public String pagar(int codigo) {
		vendaDAO.pagar(codigo);
		return "redirect:/venda/listar";
	}
	
}
