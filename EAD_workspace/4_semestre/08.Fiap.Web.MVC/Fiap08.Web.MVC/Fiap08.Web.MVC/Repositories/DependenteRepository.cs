using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Linq.Expressions;
using System.Web;
using Fiap08.Web.MVC.Models;
using Fiap08.Web.MVC.persitencia;

namespace Fiap08.Web.MVC.Repositories
{
    public class DependenteRepository : IDependenteRepository
    {

        private Aula08Context _context;

        public DependenteRepository(Aula08Context context)
        {
            _context = context;
        }

        public void Alterar(Dependente dependente)
        {
            _context.Entry(dependente).State = EntityState.Modified;
        }

        public Dependente Buscar(int codigo)
        {
            return _context.Dependentes.Find(codigo);
        }

        public IList<Dependente> BuscarPor(Expression<Func<Dependente, bool>> filtro)
        {
            return _context.Dependentes.Where(filtro).ToList();
        }

        public void Cadastrar(Dependente dependente)
        {
            _context.Dependentes.Add(dependente);
        }

        public IList<Dependente> Listar()
        {
            return _context.Dependentes.Include("Responsavel").ToList();
        }

        public void Remover(int codigo)
        {
            var dependente = Buscar(codigo);
            _context.Dependentes.Remove(dependente);
        }

    }

}