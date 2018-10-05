using Fiap08.Web.MVC.Models;
using Fiap08.Web.MVC.Units;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Fiap08.Web.MVC.Controllers
{
    public class DependenteController : Controller
    {

        private UnitOfWork _unitOfWork = new UnitOfWork();

        // GET: Dependente
        public ActionResult Cadastrar()
        {
            CarregarComboResponsaveis();
            return View();
        }

        [HttpPost]
        public ActionResult Cadastrar(Dependente dependente)
        {

            try
            {
                _unitOfWork.DependenteRepository.Cadastrar(dependente);
                _unitOfWork.Salvar();
                TempData["msgSucesso"] = "Dependente cadastrado com sucesso!";
            } catch
            {
                TempData["msgErro"] = "Erro ao tentar cadastrar o dependente!";
            }

            return RedirectToAction("Listar");
        }

        [HttpGet]
        public ActionResult Listar()
        {

            var dependentes = _unitOfWork.DependenteRepository.Listar();
            CarregarComboResponsaveis();

            return View(dependentes);
        }

        private void CarregarComboResponsaveis()
        {
            var responsaveis = _unitOfWork.ResponsavelRepository.Listar();
            ViewBag.responsaveis = new SelectList(responsaveis, "ResponsavelId", "Nome");
        }

        protected override void Dispose(bool disposing)
        {
            _unitOfWork.Dispose();
            base.Dispose(disposing);
        }

    }

}