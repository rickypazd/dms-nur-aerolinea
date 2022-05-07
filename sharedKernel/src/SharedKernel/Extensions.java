package SharedKernel;

public class Extensions {
    public static Class[] classes = {
            SharedKernel.core.AggregateRoot.class,
            SharedKernel.core.DomainEvent.class,
            SharedKernel.core.Entity.class,
            SharedKernel.core.ValueObject.class,
            SharedKernel.core.BussinessRuleValidateExeption.class,
            SharedKernel.core.IRepository.class,
            // http
            SharedKernel.http.Rest.class,
            // rule
            SharedKernel.rule.NotNullRule.class,
            SharedKernel.rule.StringNotNullOrEmptyRule.class,
            // mediator
            SharedKernel.mediator.AggregateException.class,
            SharedKernel.mediator.IMediator.class,
            SharedKernel.mediator.NotificationHandler.class,
            SharedKernel.mediator.Notification.class,
            SharedKernel.mediator.Request.class,
            SharedKernel.mediator.Response.class,
            // Class
            SharedKernel.extensions.IServiceCollection.class,
            // DB
            SharedKernel.db.DbContext.class,
            SharedKernel.db.DbSet.class,
            SharedKernel.db.ModelBuilder.class,

    };

    public static void AddKernel() {
        int i = 0;
        int l = classes.length;
        for (Class clas : classes) {
            i++;
            System.out.print("Add kerel class: (" + i + "/" + l + ")\r");
        }
        System.out.println("\n");
    }
}
