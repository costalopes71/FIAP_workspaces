using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace _07.FIAP.WEB.MVC.Models
{
    public class Tecnico
    {

        public int TecnicoId { get; set; }

        [Display(Name = "Nome do Técnico")]
        public string Nome { get; set; }
        public decimal Salario { get; set; }

    }
}