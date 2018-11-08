using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Linq.Expressions;
using System.Web;
using JogosOnlineV2.Models;
using JogosOnlineV2.Persistence;

namespace JogosOnlineV2.Repository
{
    public class JogoRepository : IJogoRepository
    {

        private JogosOnlineV2Context _context;

        public JogoRepository(JogosOnlineV2Context context)
        {
            _context = context;
        }

        public void Atualizar(Jogo jogo)
        {
            _context.Entry(jogo).State = EntityState.Modified;
        }

        public void Cadastrar(Jogo jogo)
        {
            _context.Jogos.Add(jogo);
        }

        public void Excluir(int codigo)
        {
            _context.Jogos.Remove(PesquisarPor(codigo));
        }

        public IList<Jogo> Listar()
        {
            return _context.Jogos.Include("Genero").ToList<Jogo>();
        }

        public IList<Jogo> PesquisarPor(Expression<Func<Jogo, bool>> predicate)
        {
            return _context.Jogos.Include("Genero").Where(predicate).ToList<Jogo>();
        }

        public Jogo PesquisarPor(int codigo)
        {
            return _context.Jogos.Find(codigo);
        }
    }

}