using JogosOnline.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace JogosOnline.ViewModels
{
    public class JogoViewModel
    {

        public Jogo Jogo { get; set; }
        public SelectList Generos { get; set; }
        public IList<Jogo> ListaJogos { get; set; }

    }

}