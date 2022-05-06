package SharedKernel.extensions;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;

public class DependencyInjection {

    public static Object createInstance(Class _class) throws Exception {
        Constructor[] arr_constructores = _class.getConstructors();
        if (arr_constructores.length <= 0) {
            throw new Exception("No se encontron los constructores para la clase: " + _class.getName());
        }
        Constructor constructor = arr_constructores[0];
        Class[] param_types = constructor.getParameterTypes();
        if (param_types.length <= 0) {
            return constructor.newInstance();
        }
        return constructor.newInstance(createParams(param_types).toArray());
    }

    private static ArrayList<Object> createParams(Class[] param_types) throws Exception {
        ArrayList<Object> arr_params = new ArrayList<>();
        for (Class param_type : param_types) {
            Class param_to_instance = null;
            param_to_instance = IServiceCollection.GetTransient(param_type);
            if (param_to_instance == null) {
                param_to_instance = IServiceCollection.GetScoped(param_type);
                if (param_to_instance == null) {
                    Object instance = IServiceCollection.GetSingleton(param_type);
                    if (instance != null) {
                        arr_params.add(instance);
                        continue;
                    } else {
                        param_to_instance = param_type;
                    }
                }
            }
            arr_params.add(createInstance(param_to_instance));
        }
        return arr_params;
    }
}
