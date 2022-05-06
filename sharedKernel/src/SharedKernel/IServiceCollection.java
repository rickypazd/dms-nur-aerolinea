package SharedKernel;

import java.util.HashMap;

public class IServiceCollection {
    private static HashMap<Class, Class> TrasientMap;

    public static HashMap<Class, Class> getInstance() {
        if (TrasientMap == null) {
            TrasientMap = new HashMap<>();
        }
        return TrasientMap;
    }

    public static void AddTransient(Class in, Class to) {
        getInstance().put(in, to);
    }

    public static Class GetTransient(Class in) {
        return getInstance().get(in) == null ? in : getInstance().get(in);
    }

}
