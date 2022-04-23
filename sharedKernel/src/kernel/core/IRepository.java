package kernel.core;

import kernel.core.AggregateRoot;

public interface IRepository<T, TId> {

    public T FindByKey(TId key);

    public void Create(T obj);
}
