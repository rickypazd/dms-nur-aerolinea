package Infraestructure;

import Domain.Repositories.*;
import SharedKernel.extensions.IServiceCollection;
import Infraestructure.Context.IWriteDbContext;
import Infraestructure.Repository.*;

public class Extensions {
    public static void AddInfraestructure() {
        Application.Extensions.AddApplication();
        IServiceCollection.AddMediator();

        IServiceCollection.AddScoped(IWriteDbContext.class, Infraestructure.Context.MongoDB.WriteDbContext.class);
        IServiceCollection.AddScoped(IUnitOfWork.class, UnitOfWork.class);
        IServiceCollection.AddScoped(IAeronaveRepository.class, AeronaveRepository.class);
        IServiceCollection.AddScoped(IAsientoRepository.class, AsientoRepository.class);
    }
}
