package kernel;

public class Extensions {
    public static Class[] classes = {
            kernel.core.AggregateRoot.class,
            kernel.core.DomainEvent.class,
            kernel.core.Entity.class,
            kernel.core.ValueObject.class,
            kernel.core.BussinessRuleValidateExeption.class,
            kernel.core.IRepository.class,
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
            // Class
            kernel.IServiceCollection.class,
    };
}