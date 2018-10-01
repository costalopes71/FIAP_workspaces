using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.Fiap.HelloWorld.Console.UI.Model
{
    class Carro : Veiculo
    {

        public string Marca { get; set; }
        public int Portas { get; set; }
        public bool ArCondicionado { get; set; }
        public TipoCarro Tipo { get; set; }

        //construtor
        // o base eh como se fosse o super do java
        public Carro(int ano, double potencia) : base(ano, potencia)
        {

        }

        // sobrescrever o metodo
        public override void Desligar()
        {
            System.Console.WriteLine("Virando a chave");    
        }

    }

}
