package Infraestructure;

import java.util.List;
import Domain.Repositories.IUnitOfWork;
import Infraestructure.Context.MongoDB.WriteDbContext;
import SharedKernel.core.DomainEvent;
import SharedKernel.mediator.Mediator;

public class UnitOfWork implements IUnitOfWork {

    private WriteDbContext _context;
    private Mediator _mediator;

    public UnitOfWork(WriteDbContext context, Mediator mediator) {
        _context = context;
        _mediator = mediator;
    }

    @Override
    public void commit() {

        List<DomainEvent> events = _context.getDomainEvents();
        for (DomainEvent domainEvent : events) {
            _mediator.notify(domainEvent);
        }
        _context.Commit();
    }
}