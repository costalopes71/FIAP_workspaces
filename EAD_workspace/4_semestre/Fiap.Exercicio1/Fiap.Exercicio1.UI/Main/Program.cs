using Fiap.Banco.Model;
using Fiap.Exercicio1.UI.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Fiap.Exercicio1.UI.Main
{
    class Program
    {

        static void Main(string[] args)
        {
            // instanciar a classe Conta Corrente e Conta Poupanca
            var cc = new ContaCorrente()
            {
                Agencia = 123,
                DataAbertura = DateTime.Now,
                Numero = 35188,
                Saldo = 1000,
                Tipo = TipoConta.Comum
            };

            var cp = new ContaPoupanca(0.06m)
            {
                Taxa = 2,
                Agencia = 100,
                DataAbertura = new DateTime(2018, 1, 1),
                Numero = 8999,
                Saldo = 2000
            };
            try
            {
                cc.Retirar(1002);
                Console.WriteLine(cc.Saldo);
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
            Console.ReadLine();
        }

    }
}
