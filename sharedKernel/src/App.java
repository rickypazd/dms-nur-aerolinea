import java.util.ArrayList;

import Api.AeronaveApi;
import Application.UseCases.Queries.Aeronaves.GetAeronaveByKeyHandler;
import kernel.*;
import kernel.http.Rest;
import kernel.mediator.IMediator;

public class App {
    public static void main(String[] args) throws Exception {

        // Register handlers
        IMediator.registerHandler(GetAeronaveByKeyHandler.class);
        
        // Create the kernel
        Rest.addController(AeronaveApi.class);
        Rest.start();
    }
}
