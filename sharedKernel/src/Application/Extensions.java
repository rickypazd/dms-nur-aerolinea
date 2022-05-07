package Application;

import Application.UseCases.Command.Aeronaves.CrearAeronaveHandler;
import Application.UseCases.Queries.Aeronaves.GetAll.GetAllAeronaveHandler;
import Application.UseCases.Queries.Aeronaves.GetByKey.GetAeronaveByKeyHandler;
import Domain.Factories.AeronaveFactory;
import Domain.Factories.IAeronaveFactory;
import SharedKernel.extensions.IServiceCollection;
import SharedKernel.mediator.IMediator;

public class Extensions {

    public static void AddApplication() {
        // INFO:Usamos el IMediator del kernel en cambio del MediatR de Spring
        IMediator.registerHandler(GetAllAeronaveHandler.class);
        IMediator.registerHandler(GetAeronaveByKeyHandler.class);
        IMediator.registerHandler(CrearAeronaveHandler.class);
        // IMediator.registerHandler(UpdateAsientosWhenAeronaveCreadoHandler.class);
        IServiceCollection.AddTransient(IAeronaveFactory.class, AeronaveFactory.class);
    }
}
