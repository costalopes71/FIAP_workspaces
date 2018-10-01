using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.Fiap.HelloWorld.Console.UI.Model
{
    class Lancha : Veiculo, IAquatico
    {

        // propriedade
        public bool BoiaSalvaVida { get; set; }

        // construtor
        public Lancha(int ano, int potencia) : base(ano, potencia)
        {
        
        }

        public override void Desligar()
        {
            System.Console.WriteLine("Pressionando o botao.");
        }

        public override void Acelerar()
        {
            System.Console.WriteLine("Empurrar a manete");
        }

        public void Flutuar()
        {
            System.Console.WriteLine("Flutuandooo...");
        }

    }

}