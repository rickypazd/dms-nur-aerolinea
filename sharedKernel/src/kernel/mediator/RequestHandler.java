package kernel.mediator;


public interface RequestHandler<T, R> {
    public R handle(T request);
}
