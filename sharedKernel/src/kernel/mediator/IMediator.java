package kernel.mediator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kernel.IServiceCollection;
import kernel.core.BussinessRuleValidateExeption;

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
    public <T, E> Response<E> send(Request<T> request) {
        Response<E> response = new Response<>();
        MediatorPlanRequest<T, E> plan;
        try {
            plan = new MediatorPlanRequest<>(RequestHandler.class, "handle",
                    request.getClass(),
                    ctx);
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

    class MediatorPlanRequest<T, E> {
        Method handleMethod;
        Class handlerInstanceBuilder;
        Object instance;

        public MediatorPlanRequest(Class<?> handlerType, String handlerMethodName, Class<?> messageType,
                Class context) throws NoSuchMethodException, SecurityException, ClassNotFoundException {
            handlerInstanceBuilder = getBean(handlerType, messageType, context);
            try {
                Constructor[] arr_constructores = handlerInstanceBuilder.getConstructors();
                if (arr_constructores.length > 0) {
                    Class[] param_types = arr_constructores[0].getParameterTypes();
                    if (param_types.length > 0) {
                        ArrayList<Object> params = new ArrayList<>();
                        for (Class parameter : param_types) {
                            Class param = IServiceCollection.GetTransient(parameter);
                            if (param.getConstructor() == null) {
                                throw new RuntimeException(
                                        "The handler " + param.getName()
                                                + " has no default void constructor");
                            }
                            params.add(param.getConstructor().newInstance());
                        }
                        instance = arr_constructores[0].newInstance(params.toArray());
                    } else {
                        instance = arr_constructores[0].newInstance();
                    }
                }
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException e) {
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

        public E invoke(Request<T> request)
                throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            return (E) handleMethod.invoke(instance, request);
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