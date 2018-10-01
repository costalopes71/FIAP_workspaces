using Fiap08.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace Fiap08.Web.MVC.persitencia
{
    public class Aula08Context : DbContext
    {

        public DbSet<Dependente> Dependentes { get; set; }
        public DbSet<Responsavel> Responsaveis { get; set; }

    }
}