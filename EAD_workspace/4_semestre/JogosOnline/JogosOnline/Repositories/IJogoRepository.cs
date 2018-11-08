using JogosOnline.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Web;

namespace JogosOnline.Repositories
{
    public interface IJogoRepository
    {

        void Cadastrar(Jogo jogo);
        void Atualizar(Jogo jogo);
        void Remover(int id);
        IList<Jogo> Listar();
        IList<Jogo> ListarPor(Expression<Func<Jogo, bool>> predicate);
        Jogo Buscar(int id);

    }

}