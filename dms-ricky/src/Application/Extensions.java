package Application;

import Application.UseCases.Command.Aeronaves.CrearAeronaveHandler;
import Application.UseCases.Queries.Aeronaves.GetAeronaveByKeyHandler;
import Domain.Factories.AeronaveFactory;
import Domain.Factories.IAeronaveFactory;
import SharedKernel.extensions.IServiceCollection;
import SharedKernel.mediator.IMediator;

public class Extensions {

    public static void AddApplication() {
        //INFO:Usamos el IMediator del kernel en cambio del MediatR de Spring
        IMediator.registerHandler(GetAeronaveByKeyHandler.class);
        IMediator.registerHandler(CrearAeronaveHandler.class);
        
        IServiceCollection.AddTransient(IAeronaveFactory.class, AeronaveFactory.class);
    }
}
