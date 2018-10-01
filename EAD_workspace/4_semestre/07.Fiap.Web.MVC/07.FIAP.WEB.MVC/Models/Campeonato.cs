using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace _07.FIAP.WEB.MVC.Models
{
    public class Campeonato
    {

        public int CampeonatoId { get; set; }
        public string Nome { get; set; }
        public decimal Premio { get; set; }

        // a palavra reservada virtual serve para fazer o LAZY load e tbm para sobreescrever um metodo
        public virtual IList<Time> Times { get; set; }

    }

}