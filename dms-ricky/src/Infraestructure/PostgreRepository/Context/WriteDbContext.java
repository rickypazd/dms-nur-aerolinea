package Infraestructure.PostgreRepository.Context;

import Domain.Model.Aeronaves.*;
import SharedKernel.db.DbContext;
import SharedKernel.db.DbSet;

public class WriteDbContext extends DbContext {

    public DbSet<Aeronave> Aeronave;
    public DbSet<Asiento> Asiento;

    public WriteDbContext() {
        super(WriteDbContext.class);
    }

    @Override
    public void Commit() {
        // TODO
        System.out.println("SaveChangesAsync called ot implement");
    }

    @Override
    public void Add(Object obj) {
        // TODO Auto-generated method stub

    }

    @Override
    public void Update(Object obj) {
        // TODO Auto-generated method stub

    }

}
