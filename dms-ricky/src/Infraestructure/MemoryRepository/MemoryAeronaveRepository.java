package Infraestructure.MemoryRepository;

import java.util.UUID;

import Domain.Model.Aeronaves.Aeronave;
import Domain.Repositories.IAeronaveRepository;

public class MemoryAeronaveRepository implements IAeronaveRepository {

    private MemoryDatabase _database;

    public MemoryAeronaveRepository(MemoryDatabase database) {
        _database = database;
    }

    @Override
    public Aeronave FindByKey(UUID key) {
        return _database.get_aeronaves().stream().filter(x -> x.getKey().equals(key)).findFirst().orElse(null);
    }

    @Override
    public void Create(Aeronave obj) {
        _database.get_aeronaves().add(obj);
    }

}
