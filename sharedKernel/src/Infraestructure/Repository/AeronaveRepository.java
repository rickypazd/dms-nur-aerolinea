package Infraestructure.Repository;

import java.util.UUID;

import Domain.Model.Aeronaves.Aeronave;
import Domain.Repositories.IAeronaveRepository;
import Infraestructure.Context.IWriteDbContext;
import SharedKernel.db.DbSet;

public class AeronaveRepository implements IAeronaveRepository {

    private DbSet<Aeronave> _aeronaves;

    public AeronaveRepository(IWriteDbContext database) {
        _aeronaves = database.Aeronave;
    }

    @Override
    public Aeronave FindByKey(UUID key) {
        return null;
    }

    @Override
    public void Create(Aeronave obj) {
        _aeronaves.Add(obj);
    }

}
