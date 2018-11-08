using JogosOnlineV2.Models;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace JogosOnlineV2.Persistence
{
    public class JogosOnlineV2Context : DbContext
    {

        public DbSet<Jogo> Jogos { get; set; }
        public DbSet<Genero> Generos { get; set; }

    }
}