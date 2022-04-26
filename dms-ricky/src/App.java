import kernel.IServiceCollection;
import kernel.http.Rest;

import Api.AeronaveApi;
import Application.UseCases.Queries.Aeronaves.GetAeronaveByKeyHandler;
import Domain.Factories.AeronaveFactory;
import Domain.Factories.IAeronaveFactory;
import Domain.Repositories.IAeronaveRepository;
import Infraestructure.MemoryRepository.MemoryAeronaveRepository;
import Application.UseCases.Command.Aeronaves.*;
import kernel.mediator.IMediator;

public class App {
    public static void main(String[] args) throws Exception {

        IMediator.registerHandler(GetAeronaveByKeyHandler.class);
        IMediator.registerHandler(CrearAeronaveHandler.class);

        // Add transient dependencies
        IServiceCollection.AddTransient(IAeronaveFactory.class, AeronaveFactory.class);
        IServiceCollection.AddTransient(IAeronaveRepository.class, MemoryAeronaveRepository.class);
        // Create the kernel
        Rest.addController(AeronaveApi.class);
        Rest.start();
    }
}