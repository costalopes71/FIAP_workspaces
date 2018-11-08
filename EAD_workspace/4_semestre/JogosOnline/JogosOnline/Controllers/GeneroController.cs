using JogosOnline.Models;
using JogosOnline.UnitsOfWork;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace JogosOnline.Controllers
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
                TempData["msg"] = "Genero cadastrado com sucesso!";
            } catch
            {
                TempData["msg"] = "Erro ao tentar cadastrar o gênero!";
            }
            
            return RedirectToAction("Cadastrar");
        }

        protected override void Dispose(bool disposing)
        {
            _unit.Dispose();
            base.Dispose(disposing);
        }

    }

}