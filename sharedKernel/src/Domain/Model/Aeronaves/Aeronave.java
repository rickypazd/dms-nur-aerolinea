package Domain.Model.Aeronaves;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.google.gson.Gson;

import Domain.Event.AeronaveCreado;
import Domain.Model.Aeronaves.ValueObjects.MatriculaAeronave;
import kernel.core.AggregateRoot;
import kernel.core.BussinessRuleValidateExeption;
import kernel.http.Exception.HttpException;
import kernel.http.HttpStatus;

public class Aeronave extends AggregateRoot<UUID> {

    public MatriculaAeronave matricula;
    private List<Asiento> asientos;

    public Aeronave(String matricula) {
        key = UUID.randomUUID();
        try {
            this.matricula = new MatriculaAeronave(matricula);
        } catch (BussinessRuleValidateExeption e) {
            e.printStackTrace();
            return;
        }
        asientos = new ArrayList<Asiento>();
        addDomainEvent(new AeronaveCreado(key, matricula));
    }

    public void agregarAsiento(Asiento asiento) {
        asientos.parallelStream().filter(p -> p.getKey() == asiento.getKey()).findFirst().ifPresent(p -> {
            throw new RuntimeException("El asiento ya existe");
        });
        asientos.add(asiento);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this, Aeronave.class);
    }

}
