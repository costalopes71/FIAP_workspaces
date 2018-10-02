using Fiap08.Web.MVC.Models;
using Fiap08.Web.MVC.Units;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Fiap08.Web.MVC.Controllers
{
    public class ResponsavelController : Controller
    {

        private UnitOfWork _unit = new UnitOfWork();

        // GET: Responsavel
        public ActionResult Cadastrar()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Cadastrar(Responsavel responsavel)
        {

            try
            {
                _unit.ResponsavelRepository.Cadastrar(responsavel);
                _unit.Salvar();
                TempData["msgSucesso"] = "Responsável cadastrado com sucesso!";
            } catch
            {
                TempData["msgErro"] = "Erro ao tentar cadastrar o responsável!";
            }

            return RedirectToAction("Cadastrar");
        }


        // liberar os recursos (conexao com o banco)
        protected override void Dispose(bool disposing)
        {
            _unit.Dispose();
            base.Dispose(disposing);
        }

    }

}