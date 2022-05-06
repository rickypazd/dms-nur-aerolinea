package Infraestructure.MemoryRepository;

import java.util.UUID;

import Domain.Model.Aeronaves.Aeronave;
import Domain.Repositories.IAeronaveRepository;

public class MemoryAeronaveRepository implements IAeronaveRepository {

    private MemoryDatabase _database;

    public MemoryAeronaveRepository() {
        _database = MemoryDatabase.getInstance();
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
