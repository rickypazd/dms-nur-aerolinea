package kernel.mediator;

public interface Mediator {

    public <T> Response<T> send(Request<T> request);

    public Response<Void> notify(Notification notification);
}
