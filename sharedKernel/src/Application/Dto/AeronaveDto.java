package Application.Dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AeronaveDto {

    public String matricula;
    public String perro;
    public Date fecha_test;
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
