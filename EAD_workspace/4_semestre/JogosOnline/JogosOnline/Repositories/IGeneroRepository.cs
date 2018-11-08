using JogosOnline.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace JogosOnline.Repositories
{
    public interface IGeneroRepository
    {

        void Cadastrar(Genero genero);
        IList<Genero> Listar();

    }
}