using _01.Fiap.HelloWorld.Console.UI.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
    
namespace _01.Fiap.HelloWorld.Console.UI
{
    class Program
    {
        static void Main(string[] args)
        {

            // Instanciar um objeto
            Carro c = new Carro(2010, 2.0);
            c.Ano = 2010; // este eh o SET
            c.ArCondicionado = false; // SET

            System.Console.WriteLine(c.Ano); // este eh o GET
            System.Console.WriteLine("Alooouuu C#!");

            // instanciando outro objeto ja passando os valores no contrutor
            Lancha lancha = new Lancha(2019, 140)
            {
                BoiaSalvaVida = true,
            };

            // as variaveis sao tipadas por inferencia
            var lancha2 = new Lancha(2000, 150)
            {
                Ano = 2000
            };

        }

    }

}
