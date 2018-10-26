using Exercicio_Final.Persistencia;
using Exercicio_Final.Repositories;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Exercicio_Final.UnitsOfWork
{
    public class UnitOfWork : IDisposable
    {

        private ExercicioFinalContext _context = new ExercicioFinalContext();

        private IJogoRepository _jogoRepository;
        private IGeneroRepository _generoRepository;

        public IJogoRepository JogoRepository()
        {

            if (_jogoRepository == null)
            {
                _jogoRepository = new JogoRepository(_context);
            }
            return _jogoRepository;
        }

        public IGeneroRepository GeneroRepository()
        {
            if (_generoRepository == null)
            {
                _generoRepository = new GeneroRepository(_context);
            }
            return _generoRepository;
        }

        public void Dispose()
        {
            
            if (_context != null)
            {
                _context.Dispose();
            }
            GC.SuppressFinalize(this);
        }

        public void Salvar()
        {
            _context.SaveChanges();
        }

    }

}