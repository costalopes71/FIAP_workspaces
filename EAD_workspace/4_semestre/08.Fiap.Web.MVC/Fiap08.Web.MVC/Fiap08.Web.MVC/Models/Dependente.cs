using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Fiap08.Web.MVC.Models
{
    public class Dependente
    {

        public int DependenteId { get; set; }
        public string Nome { get; set; }
        public DateTime DataNascimento { get; set; }
        public Responsavel Responsavel { get; set; }
        public int ResponsavelId { get; set; }

    }

}