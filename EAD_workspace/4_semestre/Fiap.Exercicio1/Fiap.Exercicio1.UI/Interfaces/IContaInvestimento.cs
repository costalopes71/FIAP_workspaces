using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Fiap.Banco.Interfaces
{
    // Interfaces devem comecar sempre com I na frente do nome. Eh o padrao C#.
    interface IContaInvestimento
    {

        decimal CalcularRetornoInvestimento();

    }

}
