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

        // liberar os recursos (conexao com o banco)
        protected override void Dispose(bool disposing)
        {
            _unit.Dispose();
            base.Dispose(disposing);
        }

    }

}