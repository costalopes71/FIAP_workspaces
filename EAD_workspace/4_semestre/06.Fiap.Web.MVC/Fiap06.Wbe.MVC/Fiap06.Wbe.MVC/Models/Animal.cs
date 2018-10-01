using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace Fiap06.Wbe.MVC.Models
{
    [Table("TAnimal")]
    public class Animal
    {

        // nao preciso colocar a anotacao Key pq ele ja entende que eh uma chave se o nome do meu
        // atributo for Id ou ClasseId.
        [Column("Id")]
        public int AnimalId { get; set; }

        [Required]
        [MaxLength(100)]
        public string Nome { get; set; }


        public string Raca { get; set; }

        public bool Castrado { get; set; }

        public float Peso { get; set; }

    }

}