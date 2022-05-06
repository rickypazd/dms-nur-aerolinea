package SharedKernel.mediator;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IMediator implements Mediator {
    private static ArrayList<Class> handlerClass;

    public static ArrayList<Class> getHandlers() {
        if (handlerClass == null) {
            handlerClass = new ArrayList<Class>();
        }
        return handlerClass;
    }

    public static void registerHandler(Class handler) {
        if (getHandlers().contains(handler)) {
            return;
        }
        getHandlers().add(handler);
    }

    private HashMap<Class, Object> ScopedInstances;
    private Class ctx;

    public IMediator(Class ctx) {
        this.ctx = ctx;
        ScopedInstances = new HashMap<Class, Object>();
    }

    public Object getScopedInstance(Class c) {
        return ScopedInstances.get(c);
    }

    public void setScopedInstance(Class c, Object instance) {
        ScopedInstances.put(c, instance);
    }

    @Override
    public <T, E> Response<E> send(Request<T> request) {
        Response<E> response = new Response<>();
        MediatorPlanRequest<T, E> plan;
        try {
            plan = new MediatorPlanRequest<>(RequestHandler.class, "handle",
                    request.getClass(),
                    ctx, this);
            response.data = plan.invoke(request);

        } catch (NoSuchMethodException | SecurityException | ClassNotFoundException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException e) {
            response.exception = (Exception) e;
        }
        return response;
    }

    @Override
    public Response<Void> notify(Notification notification) {
        Response<Void> response = new Response<>();
        List<NotificationHandler<Notification>> handlers = MediatorPlanNotify.getInstances(ctx,
                notification.getClass());
        List<Exception> exceptions = null;
        for (NotificationHandler<Notification> handler : handlers) {
            try {
                handler.handle(notification);
            } catch (Exception ex) {
                if (exceptions == null)
                    exceptions = new ArrayList<>();
                exceptions.add(ex);
            }
        }
        if (exceptions != null) {
            response.exception = new AggregateException(exceptions);
        }
        return response;
    }
}