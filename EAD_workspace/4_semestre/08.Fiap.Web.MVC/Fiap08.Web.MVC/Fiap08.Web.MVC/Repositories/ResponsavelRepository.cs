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
    public class ResponsavelRepository : IResponsavelRepository
    {

        private Aula08Context _context;

        public ResponsavelRepository(Aula08Context context)
        {
            _context = context;
        }

        public void Alterar(Responsavel responsavel)
        {
            _context.Entry(responsavel).State = EntityState.Modified;
        }

        public Responsavel Buscar(int codigo)
        {
            return _context.Responsaveis.Find(codigo);
        }

        public IList<Responsavel> BuscarPor(Expression<Func<Responsavel, bool>> filtro)
        {
            return _context.Responsaveis.Where(filtro).ToList();
        }

        public void Cadastrar(Responsavel responsavel)
        {
            _context.Responsaveis.Add(responsavel);
        }

        public IList<Responsavel> Listar()
        {
            return _context.Responsaveis.ToList();
        }

        public void Remover(int codigo)
        {
            var responsavel = Buscar(codigo);
            _context.Responsaveis.Remove(responsavel);
        }
    }

}