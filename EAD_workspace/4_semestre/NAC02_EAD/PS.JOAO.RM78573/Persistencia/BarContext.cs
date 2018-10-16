using PS.JOAO.RM78573.Models;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace PS.JOAO.RM78573.Persistencia
{
    public class BarContext : DbContext
    {

        public DbSet<Bebida> Bebidas { get; set; }

    }

}