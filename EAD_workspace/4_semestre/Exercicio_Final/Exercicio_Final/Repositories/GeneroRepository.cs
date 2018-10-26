using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Linq.Expressions;
using System.Web;
using Exercicio_Final.Models;
using Exercicio_Final.Persistencia;

namespace Exercicio_Final.Repositories
{
    public class GeneroRepository : IGeneroRepository
    {

        private ExercicioFinalContext _context;

        public GeneroRepository(ExercicioFinalContext context)
        {
            _context = context;
        }

        public void Alterar(Genero genero)
        {
            _context.Entry(genero).State = EntityState.Modified;
        }

        public IList<Genero> BuscarPor(Expression<Func<Genero, bool>> filtro)
        {
            return _context.Generos.Where(filtro).ToList();
        }

        public void Cadastrar(Genero genero)
        {
            _context.Generos.Add(genero);
        }

        public IList<Genero> Listar()
        {
            return _context.Generos.ToList();
        }

        public Genero Pesquisar(int codigo)
        {
            return _context.Generos.Find(codigo);
        }

        public void Remover(int codigo)
        {
            Genero genero = Pesquisar(codigo);
            _context.Generos.Remove(genero);
        }

    }

}