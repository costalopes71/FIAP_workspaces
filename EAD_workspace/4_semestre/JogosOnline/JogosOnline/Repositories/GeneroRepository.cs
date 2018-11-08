using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using JogosOnline.Models;
using JogosOnline.Persistencia;

namespace JogosOnline.Repositories
{
    public class GeneroRepository : IGeneroRepository
    {

        private JogosOnlineContext _context;

        public GeneroRepository(JogosOnlineContext context)
        {
            _context = context;
        }

        public void Cadastrar(Genero genero)
        {
            _context.Generos.Add(genero);
        }

        public IList<Genero> Listar()
        {
            return _context.Generos.ToList<Genero>();
        }

    }
}