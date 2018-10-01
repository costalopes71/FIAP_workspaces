using Fiap06.Wbe.MVC.Models;
using Fiap06.Wbe.MVC.Persistencia;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Fiap06.Wbe.MVC.Controllers
{
    public class AnimalController : Controller
    {

        private PetshopContext _context = new PetshopContext();

        // GET: Animal
        public ActionResult Cadastrar()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Cadastrar(Animal animal)
        {

            _context.Animais.Add(animal);
            _context.SaveChanges();
            TempData["msg"] = "Animal cadastrado com sucesso!";
            return RedirectToAction("Cadastrar");
        }

        [HttpGet]
        public ActionResult Listar()
        {
            List<Animal> animais = _context.Animais.ToList();
            return View(animais);
        }

        [HttpGet]
        public ActionResult Alterar(int id)
        {
            //buscar o animal no banco de dados
            var animal = _context.Animais.Find(id);
            //retorna a pagina com os dados do animal
            return View(animal);
        }

        [HttpPost]
        public ActionResult Alterar(Animal animal)
        {
            _context.Entry(animal).State = EntityState.Modified;
            _context.SaveChanges();

            TempData["msg"] = "Animal editado com sucesso!";
            return RedirectToAction("Listar");
        }
    
        [HttpPost]
        public ActionResult Remover(int codigo)
        {
            _context.Animais.Remove(_context.Animais.Find(codigo));
            _context.SaveChanges();
            TempData["msg"] = "Animal excluído com sucesso";
            return RedirectToAction("Listar");
        }

        [HttpGet]
        public ActionResult Pesquisar(string nome)
        {

            List<Animal> animais = _context.Animais.Where(a => a.Nome.Contains(nome) || a.Raca.Contains(nome)).ToList();
            return View("Listar", animais);
        }

    }

}