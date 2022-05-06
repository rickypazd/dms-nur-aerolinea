package Infraestructure;

import Domain.Repositories.IAeronaveRepository;
import Domain.Repositories.IUnitOfWork;
import Infraestructure.EF.UnitOfWork;
import Infraestructure.MemoryRepository.MemoryAeronaveRepository;
import Infraestructure.MemoryRepository.MemoryDatabase;
import SharedKernel.extensions.IServiceCollection;

public class Extensions {
    public static void AddInfraestructure() {
        Application.Extensions.AddApplication();

        IServiceCollection.AddSingleton(MemoryDatabase.class);
        IServiceCollection.AddScoped(IUnitOfWork.class, UnitOfWork.class);
        IServiceCollection.AddTransient(IAeronaveRepository.class, MemoryAeronaveRepository.class);
    }
}
