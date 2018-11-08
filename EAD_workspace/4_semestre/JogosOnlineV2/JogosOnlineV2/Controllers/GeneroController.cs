using JogosOnlineV2.Models;
using JogosOnlineV2.UnitsOfWork;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace JogosOnlineV2.Controllers
{
    public class GeneroController : Controller
    {

        private UnitOfWork _unit = new UnitOfWork();

        public ActionResult Cadastrar()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Cadastrar(Genero genero)
        {

            try
            {
                _unit.GeneroRepository.Cadastrar(genero);
                _unit.Save();
                TempData["msg"] = "Gênero cadastrado com sucesso!";
            } catch
            {
                TempData["msg"] = "Erro ao tentar cadastrar o gênero!";
            }
            
            return RedirectToAction("Cadastrar");
        }

        protected override void Dispose(bool disposing)
        {
            base.Dispose(disposing);
            _unit.Dispose();
        }

    }

}