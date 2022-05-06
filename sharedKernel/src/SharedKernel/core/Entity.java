package SharedKernel.core;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Entity<TId> {

    public TId key;
    private Collection<DomainEvent> domainEvents;
    // private Collection<DomainEvent> DomainEvents;

    public Collection<DomainEvent> getDomainEvents() {
        return domainEvents;
    }

    protected Entity() {
        domainEvents = new ArrayList<DomainEvent>();
    }

    public void addDomainEvent(DomainEvent event){
        domainEvents.add(event);
    }

    public void clearDomainEvent(){
        domainEvents.clear();
    }

    public TId getKey() {
        return key;
    }
    protected void setKey(TId key) {
        this.key = key;
    }

    protected void CheckRule(BussinessRule rule) throws BussinessRuleValidateExeption {
        if(rule == null)
        {
            throw new IllegalArgumentException("Rule cannot be null");
        }
        if (!rule.IsValid())
        {
            throw new BussinessRuleValidateExeption(rule);
        }
    }

}
