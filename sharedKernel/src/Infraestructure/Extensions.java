package Infraestructure;

import Domain.Repositories.IAeronaveRepository;
import Domain.Repositories.IUnitOfWork;
import Infraestructure.EF.UnitOfWork;
import Infraestructure.MemoryRepository.MemoryAeronaveRepository;
import SharedKernel.IServiceCollection;

public class Extensions {
    public static void AddInfraestructure() {
        IServiceCollection.AddTransient(IUnitOfWork.class, UnitOfWork.class);
        IServiceCollection.AddTransient(IAeronaveRepository.class, MemoryAeronaveRepository.class);
    }
}
