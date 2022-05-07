package SharedKernel.db;

// import SharedKernel.db.DbSet.BooleanFunction;

public interface IDbSet<T> {

    public void Add(T obj);

    // public T Single(BooleanFunction<T> fun);

    public void Update(T obj);
}
