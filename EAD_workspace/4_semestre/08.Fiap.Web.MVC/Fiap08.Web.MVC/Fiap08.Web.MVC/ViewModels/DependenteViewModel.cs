using Fiap08.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Fiap08.Web.MVC.ViewModels
{

    public class DependenteViewModel
    {

        public Dependente Dependente { get; set; }
        public SelectList Responsaveis { get; set; }

    }

}