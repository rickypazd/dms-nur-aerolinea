package Application.UseCases.Command.Aeronaves.Editar;

import java.util.UUID;

import Application.Dto.AeronaveDto;
import Domain.Model.Aeronaves.Aeronave;
import SharedKernel.mediator.Request;

public class EditarAeronaveCommand implements Request<AeronaveDto> {

    public AeronaveDto aeronave;

    public EditarAeronaveCommand(UUID key) {
        this.aeronave = new AeronaveDto();
        this.aeronave.key = key;
    }

}
