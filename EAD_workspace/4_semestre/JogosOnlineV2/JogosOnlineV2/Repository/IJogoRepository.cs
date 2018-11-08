using JogosOnlineV2.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Web;

namespace JogosOnlineV2.Repository
{
    public interface IJogoRepository
    {

        void Cadastrar(Jogo jogo);
        void Atualizar(Jogo jogo);
        void Excluir(int codigo);
        IList<Jogo> Listar();
        IList<Jogo> PesquisarPor(Expression<Func<Jogo, bool>> predicate);
        Jogo PesquisarPor(int codigo);


    }

}