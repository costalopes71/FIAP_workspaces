using _04.Fiap.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace _04.Fiap.Web.MVC.Controllers
{
    public class MedicoController : Controller
    {

        // Simular um banco de dados
        private static List<Medico> _banco = new List<Medico>();

        // GET: Medico
        public ActionResult Cadastrar()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Cadastrar(Medico medico)
        {
            _banco.Add(medico); // adiciona no banco
            TempData["msg"] = "Médico cadastrado!";
            // faz redirect para nao cadastrar varios medicos com F5, ou seja, nao usara o mesmo request
            return RedirectToAction("Cadastrar");
        }

        [HttpGet]
        public ActionResult Listar()
        {
            // envia a lista de medicos para a tela
            return View(_banco);
        }

    }

}