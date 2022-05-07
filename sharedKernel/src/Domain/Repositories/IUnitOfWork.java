package Domain.Repositories;

import SharedKernel.http.Exception.HttpException;

public interface IUnitOfWork {
    //TODO: change void for task
    public void commit() throws HttpException;
}
