using JogosOnline.Models;
using JogosOnline.UnitsOfWork;
using JogosOnline.ViewModels;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace JogosOnline.Controllers
{
    public class JogoController : Controller
    {

        private UnitOfWork _unit = new UnitOfWork();

        public ActionResult Cadastrar()
        {
            JogoViewModel viewModel = new JogoViewModel();
            viewModel.Generos = new SelectList(_unit.GeneroRepository.Listar(), "GeneroId", "Nome");
            return View(viewModel);
        }

        [HttpPost]
        public ActionResult Cadastrar(JogoViewModel viewModel)
        {

            viewModel.Jogo.Disponivel = false;

            try
            {
                _unit.JogoRepository.Cadastrar(viewModel.Jogo);
                _unit.Save();
                TempData["msg"] = "Jogo cadastrado com sucesso!";
            } catch
            {
                TempData["msg"] = "Erro ao tentar cadastrar o jogo!";
            }

            return RedirectToAction("Listar");
        }

        [HttpGet]
        public ActionResult Listar()
        {
            
            var jogos = _unit.JogoRepository.Listar();
            carregarComboGeneros();

            return View(jogos);
        }

        [HttpGet]
        public ActionResult Atualizar(int codigo)
        {
            JogoViewModel viewModel = new JogoViewModel();
            viewModel.Jogo = _unit.JogoRepository.Buscar(codigo);
            viewModel.Generos = new SelectList(_unit.GeneroRepository.Listar(), "GeneroId", "Nome");

            return View(viewModel);
        }

        [HttpPost]
        public ActionResult Atualizar(JogoViewModel viewModel)
        {

            try
            {
                _unit.JogoRepository.Atualizar(viewModel.Jogo);
                _unit.Save();
                TempData["msg"] = "Jogo editado com sucesso!";
            } catch
            {
                TempData["msg"] = "Erro ao tentar editar o jogo!";
            }
            return RedirectToAction("Listar");
        }

        [HttpPost]
        public ActionResult Remover(int codigo)
        {

            try
            {
                _unit.JogoRepository.Remover(codigo);
                _unit.Save();
                TempData["msg"] = "Jogo excluído com sucesso!";
            } catch
            {
                TempData["msg"] = "Erro ao tentar excluir o jogo!";
            }

            return RedirectToAction("Listar");
        }

        [HttpPost]
        public ActionResult Disponibilizar(int codigo)
        {

            var jogo = _unit.JogoRepository.Buscar(codigo);
            jogo.Disponivel = true;

            try
            {
                _unit.JogoRepository.Atualizar(jogo);
                _unit.Save();
                TempData["msg"] = "Jogo disponibilizado!";
            } catch
            {
                TempData["msg"] = "Erro ao tentar disponibilizar o jogo!";
            }

            return RedirectToAction("Listar");
        }

        [HttpGet]
        public ActionResult PesquisarPorNome(string nome)
        {

            var jogos = _unit.JogoRepository.ListarPor(j => j.Nome.Contains(nome));
            carregarComboGeneros();

            return View("Listar", jogos);
        }

        [HttpGet]
        public ActionResult PesquisarPorGenero(int? id)
        {

            IList<Jogo> jogos = null;
            if (id == null)
            {
                jogos = _unit.JogoRepository.Listar();
            } else
            {
                jogos = _unit.JogoRepository.ListarPor(j => j.GeneroId == id);
            }

            carregarComboGeneros();

            return View("Listar", jogos);
        }

        private void carregarComboGeneros()
        {
            ViewBag.Generos = new SelectList(_unit.GeneroRepository.Listar(), "GeneroId", "Nome");
        }

        protected override void Dispose(bool disposing)
        {
            _unit.Dispose();
            base.Dispose(disposing);
        }

    }

}