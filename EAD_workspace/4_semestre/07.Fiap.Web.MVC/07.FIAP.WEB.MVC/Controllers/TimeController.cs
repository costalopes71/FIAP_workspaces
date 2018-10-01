using _07.FIAP.WEB.MVC.Models;
using _07.FIAP.WEB.MVC.persistencia;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace _07.FIAP.WEB.MVC.Controllers
{
    public class TimeController : Controller
    {

        private BrasfootContext _context = new BrasfootContext();

        // GET: Time
        public ActionResult Cadastrar()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Cadastrar(Time time)
        {

            _context.Times.Add(time);
            _context.SaveChanges();

            TempData["msgSucesso"] = "Time cadastrado com sucesso!";

            return RedirectToAction("Cadastrar");

        }

    }
}