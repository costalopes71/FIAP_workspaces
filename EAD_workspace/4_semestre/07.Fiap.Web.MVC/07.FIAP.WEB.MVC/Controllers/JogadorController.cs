using _07.FIAP.WEB.MVC.Models;
using _07.FIAP.WEB.MVC.persistencia;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace _07.FIAP.WEB.MVC.Controllers
{
    public class JogadorController : Controller
    {

        private BrasfootContext _context = new BrasfootContext();

        // GET: Jogador
        public ActionResult Cadastrar()
        {
            CarregarComboTimes();
            return View();
        }

        [HttpPost]
        public ActionResult Cadastrar(Jogador jogador)
        {
            _context.Jogadores.Add(jogador);
            _context.SaveChanges();
            TempData["msgSucesso"] = "Jogador cadastrado com sucesso!";
            // no redirect to action ele vai para o metodo, ou seja passo no contrutor o nome do metodo
            return RedirectToAction("Cadastrar");
        }

        [HttpGet]
        public ActionResult Listar(int? codigo)
        {
            var jogadores = _context.Jogadores.Include("Time").Where(j => j.TimeId == codigo || codigo == null).ToList();
            CarregarComboTimes();
            return View(jogadores);
        }

        private void CarregarComboTimes()
        {
            //buscar os times cadastrados no banco de dados
            var times = _context.Times.ToList();
            ViewBag.Times = new SelectList(times, "TimeId", "Nome");
        }

    }

}