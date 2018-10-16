using PS.JOAO.RM78573.Models;
using PS.JOAO.RM78573.Units;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace PS.JOAO.RM78573.Controllers
{
    public class BebidaController : Controller
    {

        private UnitOfWork _unitOfWork = new UnitOfWork();

        [HttpGet]
        public ActionResult Cadastrar()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Cadastrar(Bebida bebida)
        {

            try
            {
                _unitOfWork.BebidaRepository.Cadastrar(bebida);
                _unitOfWork.Save();
                TempData["msgSucesso"] = "Bebida cadastrada com sucesso!";
            } catch
            {
                TempData["msgErro"] = "Erro ao tentar cadastrar a bebida!";
            }

            return RedirectToAction("cadastrar");
        }

        [HttpGet]
        public ActionResult Listar()
        {
            ViewBag.Bebidas = _unitOfWork.BebidaRepository.Listar();
            return View();
        }

        [HttpPost]
        public ActionResult Pesquisar(string nome)
        {
            ViewBag.Bebidas = _unitOfWork.BebidaRepository.BuscarPor(b => b.Nome.Contains(nome));
            return View("Listar");
        }

        [HttpPost]
        public ActionResult Remover(int codigo)
        {
            _unitOfWork.BebidaRepository.Remover(codigo);
            _unitOfWork.Save();
            return RedirectToAction("listar");
        }

        protected override void Dispose(bool disposing)
        {
            _unitOfWork.Dispose();
            base.Dispose(disposing);
        }

    }

}