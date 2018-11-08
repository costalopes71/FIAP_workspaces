﻿using JogosOnlineV2.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace JogosOnlineV2.Repository
{
    public interface IGeneroRepository
    {

        void Cadastrar(Genero genero);
        IList<Genero> Listar();

    }

}