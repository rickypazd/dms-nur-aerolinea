package SharedKernel.core;

import java.time.LocalDateTime;
import java.util.UUID;

import SharedKernel.mediator.Notification;

public abstract class DomainEvent implements Notification {

    public LocalDateTime OcurredOn;
    public UUID Key;

    public DomainEvent() {

    }

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
