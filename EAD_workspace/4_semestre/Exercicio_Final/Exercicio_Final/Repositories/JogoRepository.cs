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
    public class JogoRepository : IJogoRepository
    {

        private ExercicioFinalContext _context;

        public JogoRepository(ExercicioFinalContext context)
        {
            _context = context;
        }

        public void Alterar(Jogo jogo)
        {
            _context.Entry(jogo).State = EntityState.Modified;
        }

        public Jogo Buscar(int codigo)
        {
            return _context.Jogos.Find(codigo);
        }

        public void Cadastrar(Jogo jogo)
        {
            _context.Jogos.Add(jogo);
        }

        public IList<Jogo> Listar()
        {
            return _context.Jogos.Include("Genero").ToList();
        }

        public IList<Jogo> PesquisarPor(Expression<Func<Jogo, bool>> filtro)
        {
            return _context.Jogos.Include("Genero").Where(filtro).ToList();
        }

        public void Remover(int codigo)
        {
            Jogo jogo = Buscar(codigo);
            _context.Jogos.Remove(jogo);
        }

    }
}
