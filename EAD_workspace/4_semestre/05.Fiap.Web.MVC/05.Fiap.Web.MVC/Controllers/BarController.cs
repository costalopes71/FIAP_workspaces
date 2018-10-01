using _05.Fiap.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace _05.Fiap.Web.MVC.Controllers
{
    public class BarController : Controller
    {

        private static List<Bar> _bares = new List<Bar>();

        // GET: Bar
        [HttpGet]
        public ActionResult Cadastrar()
        {
            List<string> cidades = new List<string>();
            cidades.Add("São Paulo");
            cidades.Add("Rio de Janeiro");
            cidades.Add("Curitiba");
            // enviar para a pagina a lista de cidades para o select
            ViewBag.listaCidades = new SelectList(cidades);
            return View();
        }

        [HttpPost]
        public ActionResult Cadastrar(Bar bar)
        {
            _bares.Add(bar);
            // TempData mantem por 2 requests!!!
            TempData["msg"] = "Bar cadastrado com sucesso!";
            return RedirectToAction("Cadastrar");
        }

        public ActionResult Listar()
        {
            return View(_bares);
        }

    }
}