package SharedKernel.db;

// import SharedKernel.db.DbSet.BooleanFunction;

public interface IDbSet<T> {

    public void Add(T obj, DbSet<T> dbSet);

    // public T Single(BooleanFunction<T> fun);

    public void Update(T obj, DbSet<T> dbSet);

    public void Delete(T obj, DbSet<T> dbSet);
}
