package Infraestructure.PostgreRepository.Repository;

import java.util.UUID;

import Domain.Model.Aeronaves.Aeronave;
import Domain.Repositories.IAeronaveRepository;
import Infraestructure.PostgreRepository.Context.WriteDbContext;
import SharedKernel.db.DbSet;

public class AeronaveRepository implements IAeronaveRepository {

    private DbSet<Aeronave> _aeronaves;

    public AeronaveRepository(WriteDbContext database) {
        _aeronaves = database.Aeronave;
    }

    @Override
    public Aeronave FindByKey(UUID key) {
        // TODO: Implement this method
        return null;
    }

    @Override
    public void Create(Aeronave obj) {
        _aeronaves.Add(obj);
    }

}
