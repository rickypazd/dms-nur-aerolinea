package Application.Dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AeronaveDto {

    public UUID key;
    public String matricula;
    public List<AsientoDto> asientos;

    public AeronaveDto() {
        asientos = new ArrayList<>();
    }

    public void setAsientos(List<AsientoDto> asientos) {
        this.asientos = asientos;
    }

    public List<AsientoDto> getAsientos() {
        return asientos;
    }

}
