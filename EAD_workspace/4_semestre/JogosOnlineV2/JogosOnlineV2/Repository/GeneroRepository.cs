using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using JogosOnlineV2.Models;
using JogosOnlineV2.Persistence;

namespace JogosOnlineV2.Repository
{
    public class GeneroRepository : IGeneroRepository
    {

        private JogosOnlineV2Context _context;

        public GeneroRepository(JogosOnlineV2Context context)
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