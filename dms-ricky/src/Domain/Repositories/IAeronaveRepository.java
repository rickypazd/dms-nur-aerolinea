package Domain.Repositories;

import java.util.UUID;

import Domain.Model.Aeronaves.Aeronave;
import kernel.core.IRepository;

public interface IAeronaveRepository extends IRepository<Aeronave, UUID> {

}
