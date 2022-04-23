package Application.Dto;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class AeronaveDto {

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

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
