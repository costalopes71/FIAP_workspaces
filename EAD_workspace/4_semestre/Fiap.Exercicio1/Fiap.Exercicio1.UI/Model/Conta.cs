using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Fiap.Banco.Model
{
    //Classe abstrata:
    // 1 - Nao pode ser instanciada
    // 2 - Pode conter metodos abstratos (sem implementacao)
    public abstract class Conta
    {

        public int Agencia { get; set; }
        public int Numero { get; set; }
        public DateTime DataAbertura { get; set; }
        public decimal Saldo { get; set; }

        public abstract void Depositar(decimal valor);
        public abstract void Retirar(decimal valor);

    }

}
