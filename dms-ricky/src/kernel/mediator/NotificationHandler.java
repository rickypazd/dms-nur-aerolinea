package kernel.mediator;

public interface NotificationHandler<T> {
    public void handle(Notification notification);
}
