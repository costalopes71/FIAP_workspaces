using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace _07.FIAP.WEB.MVC.Controllers
{
    public class TecnicoController : Controller
    {
        // GET: Tecnico
        public ActionResult Cadastrar()
        {
            return View();
        }
    }
}