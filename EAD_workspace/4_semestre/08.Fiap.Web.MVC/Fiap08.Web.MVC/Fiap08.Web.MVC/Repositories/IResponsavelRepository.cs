using Fiap08.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;

namespace Fiap08.Web.MVC.Repositories
{
    public interface IResponsavelRepository
    {

        void Alterar(Responsavel responsavel);
        void Cadastrar(Responsavel responsavel);
        void Remover(int codigo);
        Responsavel Buscar(int codigo);
        IList<Responsavel> Listar();
        IList<Responsavel> BuscarPor(Expression<Func<Responsavel, bool>> filtro);

    }

}
