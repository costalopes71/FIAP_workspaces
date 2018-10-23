using Fiap08.Web.MVC.Models;
using Fiap08.Web.MVC.Units;
using Fiap08.Web.MVC.ViewModels;
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
            var viewModel = new DependenteViewModel();
            var lista = _unitOfWork.ResponsavelRepository.Listar();
            viewModel.Responsaveis = new SelectList(lista, "ResponsavelId", "Nome");
            return View(viewModel);
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
            return View(dependentes);
        }

        protected override void Dispose(bool disposing)
        {
            _unitOfWork.Dispose();
            base.Dispose(disposing);
        }

    }

}