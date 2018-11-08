using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace JogosOnlineV2.Models
{
    public class Genero
    {

        public int GeneroId { get; set; }
        public string Nome { get; set; }
        public IList<Jogo> ListaJogos { get; set; }

    }
}