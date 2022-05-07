package Infraestructure;

import Domain.Repositories.*;
import SharedKernel.extensions.IServiceCollection;


//Mongo Imports
import Infraestructure.MongoRepository.*;
import Infraestructure.MongoRepository.Repository.*;


public class Extensions {
    public static void AddInfraestructure() {
        Application.Extensions.AddApplication();
        IServiceCollection.AddMediator();

        IServiceCollection.AddScoped(WriteDbContext.class, WriteDbContext.class);
        IServiceCollection.AddScoped(IUnitOfWork.class, UnitOfWork.class);
        IServiceCollection.AddScoped(IAeronaveRepository.class, AeronaveRepository.class);
        // IServiceCollection.AddScoped(IAsientoRepository.class,
        // AsientoRepository.class);
    }
}
