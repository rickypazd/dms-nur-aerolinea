package Infraestructure.Context;

import Domain.Model.Aeronaves.Aeronave;
import Domain.Model.Aeronaves.Asiento;
import SharedKernel.db.DbContext;
import SharedKernel.db.DbSet;

public abstract class IWriteDbContext extends DbContext {

    public IWriteDbContext(Class dbContextClass) {
        super(dbContextClass);
    }

    public DbSet<Aeronave> Aeronave;
    public DbSet<Asiento> Asiento;
}
