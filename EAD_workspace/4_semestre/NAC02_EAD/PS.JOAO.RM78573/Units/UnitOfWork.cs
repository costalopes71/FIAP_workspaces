using PS.JOAO.RM78573.Persistencia;
using PS.JOAO.RM78573.Repositories;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace PS.JOAO.RM78573.Units
{
    public class UnitOfWork : IDisposable
    {

        private BarContext _context = new BarContext();
        private IBebidaRepository _bebidaRepository;

        public IBebidaRepository BebidaRepository
        {
            get
            {
                if (_bebidaRepository == null)
                {
                    _bebidaRepository = new BebidaRepository(_context);
                }
                return _bebidaRepository;
            }
        }


        public void Dispose()
        {
            if (_context != null)
            {
                _context.Dispose();
            }
            GC.SuppressFinalize(this);
        }

        public void Save()
        {
            _context.SaveChanges();
        }

    }

}