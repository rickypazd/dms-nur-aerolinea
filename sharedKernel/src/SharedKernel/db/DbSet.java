package SharedKernel.db;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import SharedKernel.core.DomainEvent;
import SharedKernel.core.Entity;

public class DbSet<T> {
    interface BooleanFunction<E> {
        boolean run(E str);
    }

    private List<DomainEvent> _events;
    private DbContext _context;

    private String _name;
    private Field _field;

    public DbSet(DbContext context, Field field) {
        this._name = field.getName();
        this._field = field;
        _context = context;
        _events = new ArrayList<>();
    }

    public List<DomainEvent> get_events() {
        return _events;
    }

    public Class getType() {
        Class a = (Class<T>) this.getClass();
        return this.getClass().getGenericSuperclass().getClass();
    }

    public void addEvents(T obj) {
        try {
            Entity entity = (Entity) obj;
            _events.addAll(entity.getDomainEvents());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // public T SingleAsync(BooleanFunction<T> fun) {
    // return (T) _context.SingleAsync(fun);
    // }

    public String getName() {
        return _name;
    }

    public void Update(T obj) {
        addEvents(obj);
        _context.Update(obj, this);
    }

    public void Add(T obj) {
        addEvents(obj);
        _context.Add(obj, this);
    }

    @Override
    public String toString() {
        return "[DbSet: " + _name + "]";
    }
}
