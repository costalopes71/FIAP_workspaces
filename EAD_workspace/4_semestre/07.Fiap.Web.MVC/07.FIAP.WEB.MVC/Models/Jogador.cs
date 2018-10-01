using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace _07.FIAP.WEB.MVC.Models
{
    public class Jogador
    {

        public int JogadorId { get; set; }
        public string Nome { get; set; }
        public DateTime DataNascimento { get; set; }
        public Posicao? Posicao { get; set; }

        // RELACIONAMENTOS
        public Time Time { get; set; }
        public int TimeId { get; set; }

    }

}