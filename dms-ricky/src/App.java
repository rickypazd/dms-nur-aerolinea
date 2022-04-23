import kernel.http.Rest;

import Api.AeronaveApi;
import Application.UseCases.Queries.Aeronaves.GetAeronaveByKeyHandler;
import Application.UseCases.Command.Aeronaves.*;
import kernel.mediator.IMediator;

public class App {
    public static void main(String[] args) throws Exception {

        // Register handlers
        IMediator.registerHandler(GetAeronaveByKeyHandler.class);
        IMediator.registerHandler(CrearAeronaveHandler.class);

        // Create the kernel
        Rest.addController(AeronaveApi.class);
        Rest.start();
    }
}