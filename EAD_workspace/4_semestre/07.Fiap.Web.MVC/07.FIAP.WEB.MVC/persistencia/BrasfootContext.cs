using _07.FIAP.WEB.MVC.Models;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace _07.FIAP.WEB.MVC.persistencia
{
    public class BrasfootContext : DbContext
    {

        public DbSet<Time> Times { get; set; }
        public DbSet<Jogador> Jogadores { get; set; }
        public DbSet<Campeonato> Campeonatos { get; set; }
        public DbSet<Tecnico> Tecnicos { get; set; }

    }
}