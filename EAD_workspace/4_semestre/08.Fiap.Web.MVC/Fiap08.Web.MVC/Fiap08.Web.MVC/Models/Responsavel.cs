using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Fiap08.Web.MVC.Models
{
    public class Responsavel
    {

        public int ResponsavelId { get; set; }
        public string Nome { get; set; }
        public string Telefone { get; set; }

        public IList<Dependente> ListaDependentes { get; set; }

    }
}