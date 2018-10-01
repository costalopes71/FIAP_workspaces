using _03.Fiap.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace _03.Fiap.Web.MVC.Controllers
{
    public class FilmeController : Controller
    {
        // GET: Filme
        [HttpGet]
        public ActionResult Cadastrar()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Cadastrar(Filme filme)
        {

            // passando valores para a view (pagina html)
            ViewBag.titulo = filme.Nome;

            // dessa outra forma ele mantem por 2 request (tipo o RedirectAttribute ou o FlashAtribute no java)
            TempData["msg"] = "Cadastrado com sucesso!";

            // ou mando o modelo (objeto) inteiro
            return View(filme);
            //retorna um texto para o browser
            // return Content(filme.Nome);
        }

    }
}