using Exercicio_Final.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;

namespace Exercicio_Final.Repositories
{
    public interface IJogoRepository
    {

        void Cadastrar(Jogo jogo);
        void Alterar(Jogo jogo);
        void Remover(int codigo);
        IList<Jogo> Listar();
        IList<Jogo> PesquisarPor(Expression<Func<Jogo, bool>> filtro);
        Jogo Buscar(int codigo);

    }

}
