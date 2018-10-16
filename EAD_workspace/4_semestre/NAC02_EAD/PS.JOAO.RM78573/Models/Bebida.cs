using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace PS.JOAO.RM78573.Models
{
    public class Bebida
    {

        public int BebidaId { get; set; }
        public string Nome { get; set; }
        public DateTime DataValidade { get; set; }
        public double Valor { get; set; }
        public bool Alcoolico { get; set; }

    }

}