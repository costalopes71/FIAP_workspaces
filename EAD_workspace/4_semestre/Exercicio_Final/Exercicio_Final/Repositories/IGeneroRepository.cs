using Exercicio_Final.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Web;

namespace Exercicio_Final.Repositories
{
    public interface IGeneroRepository
    {

        void Cadastrar(Genero genero);
        void Alterar(Genero genero);
        void Remover(int codigo);
        Genero Pesquisar(int codigo);
        IList<Genero> BuscarPor(Expression<Func<Genero, bool>> filtro);
        IList<Genero> Listar();
   

    }

}