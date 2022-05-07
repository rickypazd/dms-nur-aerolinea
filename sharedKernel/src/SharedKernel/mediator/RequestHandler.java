package SharedKernel.mediator;

import SharedKernel.http.Exception.HttpException;

public interface RequestHandler<T, R> {
    public R handle(T request) throws HttpException;
}
