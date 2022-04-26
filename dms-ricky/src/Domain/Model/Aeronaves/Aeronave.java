package Domain.Model.Aeronaves;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.google.gson.Gson;

import kernel.core.AggregateRoot;

public class Aeronave extends AggregateRoot<UUID> {

    public String matricula;

    private List<Asiento> asientos;

    public Aeronave(String matricula) {
        key = UUID.randomUUID();
        this.matricula = matricula;
        asientos = new ArrayList<Asiento>();
    }

    public void agregarAsiento(Asiento asiento) {
        asientos.parallelStream().filter(p -> p.getKey() == asiento.getKey()).findFirst().ifPresent(p -> {
            throw new RuntimeException("El asiento ya existe");
        });
        asientos.add(asiento);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
