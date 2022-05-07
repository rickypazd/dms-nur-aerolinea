package SharedKernel.db;

public interface IDbSet<T> {

    public interface BooleanFunction<E> {
        boolean run(E str);
    }

    public void Add(T obj, DbSet<T> dbSet);

    public T Single(BooleanFunction<T> fun, DbSet<T> dbSet);

    public void Update(T obj, DbSet<T> dbSet);

    public void Delete(T obj, DbSet<T> dbSet);
}
