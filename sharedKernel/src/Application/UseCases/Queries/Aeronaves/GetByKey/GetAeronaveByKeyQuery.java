package Application.UseCases.Queries.Aeronaves.GetByKey;

import java.util.UUID;
import Application.Dto.AeronaveDto;
import SharedKernel.mediator.Request;

public class GetAeronaveByKeyQuery implements Request<AeronaveDto> {


    public GetAeronaveByKeyQuery(UUID key) {
        this.key = key;
    }

    public UUID key;

}
