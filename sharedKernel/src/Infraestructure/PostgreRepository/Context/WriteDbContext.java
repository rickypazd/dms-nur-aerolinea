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
    public void onModelCreating() {

    }

    @Override
    public void SaveChangesAsync() {
        // TODO
        System.out.println("SaveChangesAsync called ot implement");
    }
}
