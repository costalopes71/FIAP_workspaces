using Fiap08.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;

namespace Fiap08.Web.MVC.Repositories
{
    public interface IDependenteRepository
    {

        void Cadastrar(Dependente dependente);
        void Alterar(Dependente dependente);
        void Remover(int codigo);
        Dependente Buscar(int codigo);
        IList<Dependente> Listar();
        IList<Dependente> BuscarPor(Expression<Func<Dependente, bool>> filtro);

    }

}
