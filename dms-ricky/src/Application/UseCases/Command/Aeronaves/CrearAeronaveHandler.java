package Application.UseCases.Command.Aeronaves;

import java.util.UUID;
import kernel.mediator.RequestHandler;

public class CrearAeronaveHandler implements RequestHandler<CrearAeronaveCommand, UUID> {

    public CrearAeronaveHandler(){

    }
    @Override
    public UUID handle(CrearAeronaveCommand request) {
        System.out.println("Entro al handler");
        return UUID.randomUUID();
    }

}
