using Fiap08.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Fiap08.Web.MVC.ViewModels
{
    public class ResponsavelViewModel
    {

        public Responsavel Responsavel { get; set; }
        public IList<Responsavel> Responsaveis { get; set; }

    }

}