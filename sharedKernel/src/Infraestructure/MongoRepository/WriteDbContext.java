package Infraestructure.MongoRepository;

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
        System.out.println("WriteDbContext::Commit Not implemented");
    }

    @Override
    public void Add(Object obj) {
        System.out.println("WriteDbContext::Add Not implemented");
    }

    @Override
    public void Update(Object obj) {
        System.out.println("WriteDbContext::Update Not implemented");

    }

}
