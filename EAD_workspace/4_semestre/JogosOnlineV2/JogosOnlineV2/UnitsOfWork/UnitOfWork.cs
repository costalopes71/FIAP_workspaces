using JogosOnlineV2.Persistence;
using JogosOnlineV2.Repository;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace JogosOnlineV2.UnitsOfWork
{
    public class UnitOfWork : IDisposable
    {

        private JogosOnlineV2Context _context = new JogosOnlineV2Context();
        private IGeneroRepository _generoRepository;
        private IJogoRepository _jogoRepository;

        public IGeneroRepository GeneroRepository
        {
            get
            {
                if (_generoRepository == null)
                {
                    _generoRepository = new GeneroRepository(_context);
                }
                return _generoRepository;
            }
        }

        public IJogoRepository JogoRepository
        {
            get
            {
                if (_jogoRepository == null)
                {
                    _jogoRepository = new JogoRepository(_context);
                }
                return _jogoRepository;
            }
        }

        public void Save()
        {
            _context.SaveChanges();
        }

        public void Dispose()
        {
            if (_context != null)
            {
                _context.Dispose();
            }
            GC.SuppressFinalize(this);
        }
    }


}