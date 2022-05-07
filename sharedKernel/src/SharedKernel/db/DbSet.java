package SharedKernel.db;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import SharedKernel.core.DomainEvent;
import SharedKernel.core.Entity;
import SharedKernel.db.IDbSet.BooleanFunction;

public class DbSet<T> {

    private List<DomainEvent> _events;
    private DbContext _context;

    private String _name;
    private Field _field;
    private Class<T> _type;

    public DbSet(DbContext context, Field field) {
        this._name = field.getName();
        this._field = field;
        ParameterizedType genericType = (ParameterizedType) field.getGenericType();
        _type = (Class<T>) genericType.getActualTypeArguments()[0];
        _context = context;
        _events = new ArrayList<>();
    }

    public Class<T> get_type() {
        return _type;
    }

    public List<DomainEvent> get_events() {
        return _events;
    }

    private void addEvents(T obj) {
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

    public T Single(BooleanFunction<T> fun) {
        return (T) _context.Single(fun, this);
    }

    @Override
    public String toString() {
        return "[DbSet: " + _name + "]";
    }
}
