package Infraestructure.PostgreRepository.Repository;

import java.util.UUID;

import Domain.Model.Aeronaves.Asiento;
import Domain.Repositories.IAsientoRepository;
import Infraestructure.PostgreRepository.Context.WriteDbContext;
import SharedKernel.db.DbSet;

public class AsientoRepository implements IAsientoRepository {

    private DbSet<Asiento> _asientos;

    public AsientoRepository(WriteDbContext database) {
        _asientos = database.Asiento;
    }

    @Override
    public Asiento FindByKey(UUID key) {
        // TODO: Implement this method
        return null;
    }

    @Override
    public void Create(Asiento obj) {
        _asientos.AddAsync(obj);
    }
}
