package Infraestructure.Repository;

import java.util.List;
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
        return _aeronaves.Single(obj -> obj.key.equals(key));
    }

    @Override
    public void Create(Aeronave obj) {
        _aeronaves.Add(obj);
    }

    @Override
    public List<Aeronave> GetAll() {
        return _aeronaves.All();
    }

    @Override
    public Aeronave Delete(Aeronave obj) {
        _aeronaves.Delete((it -> it.key.equals(obj.key)));
        return obj;

    }

    @Override
    public Aeronave Update(Aeronave obj) {
        _aeronaves.Update(obj, (it -> it.key.equals(obj.key)));
        return obj;

    }

}
