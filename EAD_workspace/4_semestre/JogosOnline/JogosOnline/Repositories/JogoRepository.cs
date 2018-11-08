using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Linq.Expressions;
using System.Web;
using JogosOnline.Models;
using JogosOnline.Persistencia;

namespace JogosOnline.Repositories
{
    public class JogoRepository : IJogoRepository
    {

        private JogosOnlineContext _context;

        public JogoRepository(JogosOnlineContext context)
        {
            _context = context;
        }

        public void Atualizar(Jogo jogo)
        {
            _context.Entry(jogo).State = EntityState.Modified;
        }

        public Jogo Buscar(int id)
        {
            return _context.Jogos.Find(id);
        }

        public void Cadastrar(Jogo jogo)
        {
            _context.Jogos.Add(jogo);
        }

        public IList<Jogo> Listar()
        {
            return _context.Jogos.Include("Genero").ToList<Jogo>();
        }

        public IList<Jogo> ListarPor(Expression<Func<Jogo, bool>> predicate)
        {
            return _context.Jogos.Include("Genero").Where(predicate).ToList<Jogo>();
        }

        public void Remover(int id)
        {
            _context.Jogos.Remove(Buscar(id));
        }
    }
}