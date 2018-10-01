using Fiap.Banco.Model;
using Fiap.Exercicio1.UI.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Fiap.Banco.Model
{
    // se eu nao puser nenhum modificador de acesso a classe fica como internal
    public sealed class ContaCorrente : Conta
    {

        public TipoConta Tipo { get; set; }

        public override void Depositar(decimal valor)
        {
            Saldo += valor;
        }

        public override void Retirar(decimal valor)
        {

            if (Tipo == TipoConta.Comum && Saldo < valor)
            {
                throw new Exception("Saldo insuficiente.");
            }

            Saldo -= valor;
        }

    }

}
