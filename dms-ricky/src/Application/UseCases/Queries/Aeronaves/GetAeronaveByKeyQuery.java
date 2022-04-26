package Application.UseCases.Queries.Aeronaves;

import java.util.List;
import java.util.UUID;

import Application.Dto.AeronaveDto;
import Application.Dto.AsientoDto;
import kernel.mediator.Request;

public class GetAeronaveByKeyQuery implements Request<AeronaveDto> {

    public GetAeronaveByKeyQuery() {
        // System.out.println("ASdasd");
    }

    public GetAeronaveByKeyQuery(UUID key) {
        this.key = key;
    }

    public UUID key;

}
