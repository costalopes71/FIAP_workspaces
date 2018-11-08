using JogosOnline.Models;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace JogosOnline.Persistencia
{
    public class JogosOnlineContext : DbContext
    {

        public DbSet<Jogo> Jogos { get; set; }
        public DbSet<Genero> Generos { get; set; }

    }
}