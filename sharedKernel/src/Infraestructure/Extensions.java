package Infraestructure;

import SharedKernel.extensions.IServiceCollection;

import Infraestructure.PostgreRepository.*;
import Infraestructure.PostgreRepository.Context.WriteDbContext;
import Infraestructure.PostgreRepository.Repository.*;

public class Extensions {
    public static void AddInfraestructure() {
        Application.Extensions.AddApplication();
        IServiceCollection.AddMediator();

        IServiceCollection.AddScoped(WriteDbContext.class, WriteDbContext.class);
        IServiceCollection.AddScoped(Domain.Repositories.IUnitOfWork.class, UnitOfWork.class);
        IServiceCollection.AddScoped(Domain.Repositories.IAeronaveRepository.class, AeronaveRepository.class);
        IServiceCollection.AddScoped(Domain.Repositories.IAsientoRepository.class, AsientoRepository.class);
    }
}
