package SharedKernel.db;

import java.util.ArrayList;
import java.util.List;

import SharedKernel.core.DomainEvent;
import SharedKernel.core.Entity;

public class DbSet<T> implements IDbSet<T> {
    interface BooleanFunction<E> {
        boolean run(E str);
    }

    private List<DomainEvent> _events;

    private DbContext _context;

    public DbSet(DbContext context) {
        _context = context;
        _events = new ArrayList<>();
    }

    public List<DomainEvent> get_events() {
        return _events;
    }

    public void addEvents(T obj) {
        try {
            Entity entity = (Entity) obj;
            _events.addAll(entity.getDomainEvents());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Add(T obj) {
        addEvents(obj);
        _context.Add(obj);
    }

    // public T SingleAsync(BooleanFunction<T> fun) {
    // return (T) _context.SingleAsync(fun);
    // }

    public void Update(T obj) {
        addEvents(obj);
        _context.Update(obj);
    }
}
