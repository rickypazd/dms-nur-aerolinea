package kernel.mediator;

import java.io.Console;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import kernel.core.ApplicationContext;

/**
 * Default implementation of Mediator
 *
 */

public class IMediator implements Mediator {

    /**
     * Initializes a new instance of Mediator
     * 
     * @param ctx Application context of Spring
     */

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

    private Class ctx;

    public IMediator(Class ctx) {
        this.ctx = ctx;
    }

    @Override
    public <T> Response<T> send(Request<T> request) {
        Response<T> response = new Response<>();
        try {
            MediatorPlanRequest<T> plan = new MediatorPlanRequest<>(RequestHandler.class, "handle", request.getClass(),
                    ctx);
            response.data = plan.invoke(request);
        } catch (Exception e) {
            response.exception = e;
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

    class MediatorPlanRequest<T> {
        Method handleMethod;
        Class handlerInstanceBuilder;
        Object instance;

        public MediatorPlanRequest(Class<?> handlerType, String handlerMethodName, Class<?> messageType,
                Class context) throws NoSuchMethodException, SecurityException, ClassNotFoundException {
            handlerInstanceBuilder = getBean(handlerType, messageType, context);
            try {
                instance = handlerInstanceBuilder.getConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // handleMethod = handlerInstanceBuilder.getDeclaredMethod(handlerMethodName,
            // messageType);
            handleMethod = handlerInstanceBuilder.getMethod(handlerMethodName, messageType);
        }

        private Map<String, ?> getBeansOfType(Class context, Class<?> handlerType) {
            return new HashMap<>();
        }

        private Class getBean(Class<?> handlerType, Class<?> messageType, Class context)
                throws ClassNotFoundException {
            // TODO: implement

            ArrayList<Class> mediators = IMediator.getHandlers();
            for (Class mediator : mediators) {
                String name = mediator.getGenericInterfaces()[0].getTypeName();
                name = name.replaceAll(">", "");
                String[] parts = name.split("<");
                String[] parts2 = parts[1].split(",");
                if (parts2[0].equals(messageType.getName())) {
                    // return ApplicationContext.getBean(mediator);
                    return mediator;
                }

            }
            // Map<String, ?> beans = getBeansOfType(context, handlerType);

            // Map<String, ?> beans = context.getBeansOfType(handlerType);
            // for (Entry<String, ?> entry : beans.entrySet()) {
            // Class<?> clazz = entry.getValue().getClass();
            // Type[] interfaces = clazz.getGenericInterfaces();
            // for (Type interace : interfaces) {
            // Type parameterType = ((ParameterizedType)
            // interace).getActualTypeArguments()[0];
            // if (parameterType.equals(messageType)) {
            // return entry.getValue();
            // }
            // }
            // }

            throw new ClassNotFoundException("Handler not found. Did you forget to register this?");
        }

        public T invoke(Request<T> request)
                throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            return (T) handleMethod.invoke(instance, request);
        }
    }

    static class MediatorPlanNotify {
        public static List<NotificationHandler<Notification>> getInstances(Class ctx,
                Class<?> messageType) {
            List<NotificationHandler<Notification>> instances = new ArrayList<>();
            // TODO: implement

            // Map<String, ?> beans = ctx.getBeansOfType(NotificationHandler.class);
            // for (Entry<String, ?> entry : beans.entrySet()) {
            // Class<?> clazz = entry.getValue().getClass();
            // Type[] interfaces = clazz.getGenericInterfaces();
            // for (Type interace : interfaces) {
            // Type parameterType = ((ParameterizedType)
            // interace).getActualTypeArguments()[0];
            // if (parameterType.equals(messageType)) {
            // instances.add((NotificationHandler<Notification>) entry.getValue());
            // }
            // }
            // }

            return instances;
        }
    }
}