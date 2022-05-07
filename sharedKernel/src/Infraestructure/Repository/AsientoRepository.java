package Infraestructure.Repository;

import java.util.UUID;

import Domain.Model.Aeronaves.Asiento;
import Domain.Repositories.IAsientoRepository;
import Infraestructure.Context.IWriteDbContext;
import SharedKernel.db.DbSet;

public class AsientoRepository implements IAsientoRepository {

    private DbSet<Asiento> _asientos;

    public AsientoRepository(IWriteDbContext database) {
        _asientos = database.Asiento;
    }

    @Override
    public Asiento FindByKey(UUID key) {
        return null;
    }

    @Override
    public void Create(Asiento obj) {
        _asientos.Add(obj);
    }
}
