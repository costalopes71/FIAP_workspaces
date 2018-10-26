using Exercicio_Final.Models;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace Exercicio_Final.Persistencia
{
    public class ExercicioFinalContext : DbContext
    {

        public DbSet<Jogo> Jogos { get; set; }
        public DbSet<Genero> Generos { get; set; }

    }
}