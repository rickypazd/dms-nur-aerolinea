package kernel.core;

import java.util.Date;
import java.util.UUID;

public abstract class DomainEvent {

    public Date OcurredOn;
    public UUID Key;

    protected DomainEvent(Date ocurredOn) {
        this.OcurredOn = ocurredOn;
        this.Key = UUID.randomUUID();
    }

    public Date getOcurredOn() {
        return OcurredOn;
    }

    public UUID getKey() {
        return Key;
    }

}
