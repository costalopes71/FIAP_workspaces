package br.com.fiap.springjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.springjpa.dao.ProdutoDAO;
import br.com.fiap.springjpa.exceptions.KeyNotFoundException;
import br.com.fiap.springjpa.model.Produto;

@Controller
@RequestMapping("produto")
public class ProdutoController {

	@Autowired
	private ProdutoDAO produtoDAO;
	
	@GetMapping("cadastrar")
	public String abrirPaginaCadastro() {
		return "/produto/cadastrar";
	}
	
	@PostMapping("cadastrar")
	@Transactional
	public ModelAndView cadastrar(Produto produto, RedirectAttributes redirectAttributes) {
		ModelAndView model = new ModelAndView("redirect:/produto/cadastrar");
		
		try {
			produtoDAO.inserir(produto);
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("mensagemErro", "Erro ao tentar cadastrar!");
			return model;
		}

		redirectAttributes.addFlashAttribute("mensagemSucesso", "Produto cadastrado com sucesso!");
		return model;
	}
	
	@GetMapping("listar")
	public ModelAndView listarProdutos() {
		ModelAndView model = new ModelAndView("produto/listar");
		
		try {
			List<Produto> produtos = produtoDAO.listar();
			model.addObject("produtos", produtos);
		} catch (Exception e) {
			System.out.println("Erro ao tentar listar");
		}
		
		return model;
	}
	
	@GetMapping("editar/{id}")
	public ModelAndView atualizar(@PathVariable("id") int codigo) {
		Produto produto = produtoDAO.pesquisar(codigo);
		return new ModelAndView("produto/atualizar").addObject("produto", produto);
	}
	
	@PostMapping("editar")
	@Transactional
	public ModelAndView editar(Produto produto, RedirectAttributes redirectAttribute) {
		
		produtoDAO.atualizar(produto);
		
		redirectAttribute.addFlashAttribute("mensagemSucesso", "Produto editado com sucesso!");
		return new ModelAndView("redirect:/produto/listar");
	}
	
	@PostMapping("excluir")
	@Transactional
	public ModelAndView excluir(int codigo, RedirectAttributes redirectAttribute) {
		try {
			produtoDAO.remover(codigo);
			redirectAttribute.addFlashAttribute("mensagemSucesso", "Produto excluido com sucesso!");
		} catch (KeyNotFoundException e) {
			redirectAttribute.addFlashAttribute("mensagemErro", "Erro ao tentar excluir o produto!");
		}
		return new ModelAndView("redirect:/produto/listar");
	}
	
}