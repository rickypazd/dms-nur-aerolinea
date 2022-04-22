package kernel;

public class Kernel {
    public Class[] classes = {
            // core
            kernel.core.AggregateRoot.class,
            kernel.core.DomainEvent.class,
            kernel.core.Entity.class,
            // http
            kernel.http.Rest.class,
            // rule
            kernel.rule.NotNullRule.class,
            kernel.rule.StringNotNullOrEmptyRule.class,
    };
}
