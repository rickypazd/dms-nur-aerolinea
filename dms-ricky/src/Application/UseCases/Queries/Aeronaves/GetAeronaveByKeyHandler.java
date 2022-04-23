package Application.UseCases.Queries.Aeronaves;

import java.util.UUID;

import Application.Dto.AeronaveDto;
import kernel.mediator.RequestHandler;

public class GetAeronaveByKeyHandler implements RequestHandler<GetAeronaveByKeyQuery, AeronaveDto> {

    public GetAeronaveByKeyHandler() {

    }

    @Override
    public AeronaveDto handle(GetAeronaveByKeyQuery request) {
        System.out.println("Entro al handler");
        return new AeronaveDto();
    }
}
