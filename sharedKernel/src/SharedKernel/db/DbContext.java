package SharedKernel.db;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import SharedKernel.core.DomainEvent;

public abstract class DbContext implements IDbContext {
    private List<DbSet> _dbSets;
    private Class _dbContextClass;

    public DbContext(Class dbContextClass) {
        _dbContextClass = dbContextClass;
        _dbSets = new ArrayList<>();
        this.instanceDbSet();
        onModelCreating(_dbSets);
    }

    public List<DomainEvent> getDomainEvents() {
        List<DomainEvent> events = new ArrayList<>();
        for (DbSet dbSet : _dbSets) {
            events.addAll(dbSet.get_events());
        }
        return events;
    }

    public void instanceDbSet() {
        Field[] fields = _dbContextClass.getFields();
        for (Field field : fields) {
            if (field.getType().getName().contains(SharedKernel.db.DbSet.class.getName())) {
                System.out.println(field.getName());
                try {
                    field.set(this, new DbSet<>(this, field));
                    _dbSets.add((DbSet) field.get(this));
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }

        }
    }

}
