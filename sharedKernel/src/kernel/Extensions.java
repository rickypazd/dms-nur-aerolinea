package kernel;

public class Extensions {
    public Class[] classes = {
            kernel.core.AggregateRoot.class,
            kernel.core.DomainEvent.class,
            kernel.core.Entity.class,
            // http
            kernel.http.Rest.class,
            // rule
            kernel.rule.NotNullRule.class,
            kernel.rule.StringNotNullOrEmptyRule.class,
            // mediator
            kernel.mediator.AggregateException.class,
            kernel.mediator.IMediator.class,
            kernel.mediator.NotificationHandler.class,
            kernel.mediator.Notification.class,
            kernel.mediator.Request.class,
            kernel.mediator.Response.class,
    };
}
