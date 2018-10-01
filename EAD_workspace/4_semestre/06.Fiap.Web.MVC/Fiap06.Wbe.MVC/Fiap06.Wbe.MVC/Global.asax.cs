using Fiap06.Wbe.MVC.Persistencia;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

namespace Fiap06.Wbe.MVC
{
    public class MvcApplication : System.Web.HttpApplication
    {
        // Lembrar de configurar o Database.SetInitializer, do jeito que esta abaixo ele cria a base
        // denovo sempre que o Model mudar.
        protected void Application_Start()
        {
            AreaRegistration.RegisterAllAreas();
            RouteConfig.RegisterRoutes(RouteTable.Routes);
            Database.SetInitializer(new DropCreateDatabaseIfModelChanges<PetshopContext>());
        }
    }



}
