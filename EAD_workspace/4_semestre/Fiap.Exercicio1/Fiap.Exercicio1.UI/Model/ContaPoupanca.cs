using Fiap.Banco.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Fiap.Banco.Model
{
    public class ContaPoupanca : Conta, IContaInvestimento
    {

        // propriedades
        public decimal Taxa { get; set; }

        // atributos
        private readonly decimal _rendimento;

        public ContaPoupanca(decimal valor)
        {
            _rendimento = valor;
        }

        public decimal CalcularRetornoInvestimento()
        {
            return Saldo * _rendimento;
        }

        public override void Depositar(decimal valor)
        {
            Saldo += valor;
        }

        public override void Retirar(decimal valor)
        {
            if (Saldo >= (valor + Taxa))
            {
                Saldo -= (valor + Taxa);
            } else
            {
                throw new Exception("Saldo insuficiente.");
            }
        }

        public decimal Rendimento
        {
            get { return _rendimento; }
        }

    }

}
