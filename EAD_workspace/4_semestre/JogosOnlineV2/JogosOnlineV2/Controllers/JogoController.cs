using JogosOnlineV2.Models;
using JogosOnlineV2.UnitsOfWork;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace JogosOnlineV2.Controllers
{
    public class JogoController : Controller
    {

        private UnitOfWork _unit = new UnitOfWork();

        public ActionResult Cadastrar()
        {
            carregarGenerosNoCombo();
            return View();
        }

        [HttpPost]
        public ActionResult Cadastrar(Jogo jogo)
        {

            try
            {
                jogo.Disponivel = false;
                _unit.JogoRepository.Cadastrar(jogo);
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

            var lista = _unit.JogoRepository.Listar();
            carregarGenerosNoCombo();
            return View(lista);
        }

        [HttpGet]
        public ActionResult Atualizar(int id)
        {
            var jogo = _unit.JogoRepository.PesquisarPor(id);
            carregarGenerosNoCombo();
            return View(jogo);
        }

        [HttpGet]
        public ActionResult PesquisarPorNome(string nome)
        {

            var lista = _unit.JogoRepository.PesquisarPor(j => j.Nome.Contains(nome));
            carregarGenerosNoCombo();
            return View("Listar", lista);
        }

        [HttpGet]
        public ActionResult PesquisarPorGenero(int? id)
        {

            var lista = _unit.JogoRepository.PesquisarPor(j => j.GeneroId == id);
            carregarGenerosNoCombo();
            return View("Listar", lista);

        }

        private void carregarGenerosNoCombo()
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