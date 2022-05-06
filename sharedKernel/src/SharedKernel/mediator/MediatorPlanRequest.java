package SharedKernel.mediator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import SharedKernel.extensions.DependencyInjection;

public class MediatorPlanRequest<T, E> {
    Method handleMethod;
    Class handlerInstanceBuilder;
    Object instance;

    public MediatorPlanRequest(Class<?> handlerType, String handlerMethodName, Class<?> messageType,
            Class context) throws NoSuchMethodException, SecurityException, ClassNotFoundException {
        handlerInstanceBuilder = getBean(handlerType, messageType, context);
        try {
            instance = DependencyInjection.createInstance(handlerInstanceBuilder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        handleMethod = handlerInstanceBuilder.getMethod(handlerMethodName, messageType);
    }

    private Map<String, ?> getBeansOfType(Class context, Class<?> handlerType) {
        return new HashMap<>();
    }

    private Class getBean(Class<?> handlerType, Class<?> messageType, Class context)
            throws ClassNotFoundException {
        ArrayList<Class> mediators = IMediator.getHandlers();
        for (Class mediator : mediators) {
            String name = mediator.getGenericInterfaces()[0].getTypeName();
            name = name.replaceAll(">", "");
            String[] parts = name.split("<");
            String[] parts2 = parts[1].split(",");
            if (parts2[0].equals(messageType.getName())) {
                return mediator;
            }

        }

        throw new ClassNotFoundException("Handler not found. Did you forget to register this?");
    }

    public E invoke(Request<T> request)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        return (E) handleMethod.invoke(instance, request);
    }
}
