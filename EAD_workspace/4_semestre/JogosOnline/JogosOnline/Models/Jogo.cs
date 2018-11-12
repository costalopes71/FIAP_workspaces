﻿using System;

namespace JogosOnline.Models
{
    public class Jogo
    {

        public int JogoId { get; set; }
        public string Nome { get; set; }
        public DateTime DataLancamento { get; set; }
        public Plataforma? Plataforma { get; set; }
        public bool Disponivel { get; set; }
        public Genero Genero { get; set; }
        public int GeneroId { get; set; }

    }
}