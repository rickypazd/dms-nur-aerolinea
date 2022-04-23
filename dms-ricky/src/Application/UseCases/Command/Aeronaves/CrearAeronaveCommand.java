package Application.UseCases.Command.Aeronaves;

import java.util.List;
import java.util.UUID;

import Application.Dto.AsientoDto;
import kernel.mediator.Request;

public class CrearAeronaveCommand implements Request<UUID> {

    public CrearAeronaveCommand() {
        System.out.println("entro");
    }

    public CrearAeronaveCommand(List<AsientoDto> asientos) {
        this.asientos = asientos;
    }

    public List<AsientoDto> asientos;

    public List<AsientoDto> getAsientos() {
        return asientos;
    }

    public void setAsientos(List<AsientoDto> asientos) {
        this.asientos = asientos;
    }
}
