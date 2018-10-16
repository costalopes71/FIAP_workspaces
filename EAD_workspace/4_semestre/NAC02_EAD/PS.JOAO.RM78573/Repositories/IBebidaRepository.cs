using PS.JOAO.RM78573.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;

namespace PS.JOAO.RM78573.Repositories
{
    public interface IBebidaRepository
    {

        void Cadastrar(Bebida bebida);
        void Remover(int codigo);
        IList<Bebida> Listar();
        IList<Bebida> BuscarPor(Expression<Func<Bebida, bool>> filtro);

    }

}
