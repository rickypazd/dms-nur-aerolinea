package SharedKernel.core;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class DomainEvent {

    public LocalDateTime OcurredOn;
    public UUID Key;

    protected DomainEvent(LocalDateTime ocurredOn) {
        this.OcurredOn = ocurredOn;
        this.Key = UUID.randomUUID();
    }

    public LocalDateTime getOcurredOn() {
        return OcurredOn;
    }

    public UUID getKey() {
        return Key;
    }

}
