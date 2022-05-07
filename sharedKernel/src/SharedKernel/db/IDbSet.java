package SharedKernel.db;

import java.util.List;

public interface IDbSet<T> {

    public interface BooleanFunction<E> {
        boolean run(E str);
    }

    public void Add(T obj, DbSet<T> dbSet);

    public void Update(T obj, BooleanFunction<T> fun, DbSet<T> dbSet);

    public void Delete(BooleanFunction<T> fun, DbSet<T> dbSet);

    public List<T> All(DbSet<T> dbSet);

    public T Single(BooleanFunction<T> fun, DbSet<T> dbSet);

    public List<T> Filter(BooleanFunction<T> fun, DbSet<T> dbSet);

}
