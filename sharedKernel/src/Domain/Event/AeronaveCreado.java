package Domain.Event;

import java.time.LocalDateTime;
import java.util.UUID;

import SharedKernel.core.DomainEvent;

public class AeronaveCreado extends DomainEvent {

    public UUID keyAeronave;
    public String matricula;

    public AeronaveCreado() {
        super();
    }

    public AeronaveCreado(UUID keyAeronave, String matricula) {
        super(LocalDateTime.now());
        this.keyAeronave = keyAeronave;
        this.matricula = matricula;
    }

    public UUID getKeyAeronave() {
        return this.keyAeronave;
    }

    public void setKeyAeronave(UUID keyAeronave) {
        this.keyAeronave = keyAeronave;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

}
