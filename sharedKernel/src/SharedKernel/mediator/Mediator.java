package SharedKernel.mediator;

public interface Mediator {

    public <T, E> Response<E> send(Request<T> request);

    public Response notify(Notification notification);
}
