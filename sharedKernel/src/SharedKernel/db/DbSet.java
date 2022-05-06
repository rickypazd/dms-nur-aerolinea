package SharedKernel.db;

import java.util.ArrayList;
import java.util.List;

import SharedKernel.core.DomainEvent;
import SharedKernel.core.Entity;

public class DbSet<T> {
    interface BooleanFunction<E> {
        boolean run(E str);
    }

    private List<DomainEvent> _events;

    public DbSet() {
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

    public void AddAsync(T obj) {
        addEvents(obj);
        // TODO: Complete on return task
    }

    public T SingleAsync(BooleanFunction<T> fun) {
        // TODO: Complete on return task
        return null;
    }

    public void Update(T obj) {
        addEvents(obj);
    }
}
