package Application.UseCases.Command.Aeronaves.Crear;

import java.util.List;
import java.util.UUID;

import Application.Dto.AeronaveDto;
import Application.Dto.AsientoDto;
import SharedKernel.mediator.Request;

public class CrearAeronaveCommand implements Request<AeronaveDto> {


    public CrearAeronaveCommand(AeronaveDto ero) {
        this.matricula = ero.matricula;
    }

    public String matricula;

    public List<AsientoDto> asientos;

    public List<AsientoDto> getAsientos() {
        return asientos;
    }

    public void setAsientos(List<AsientoDto> asientos) {
        this.asientos = asientos;
    }
}
