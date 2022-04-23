package kernel.core;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {

    private Map<String, Object> contextMap;

    public ApplicationContext() {
        this.contextMap = new HashMap<>();
    }

    public Map<String, ?> getBeansOfType(Class<?> type) {
        return new HashMap<>();
    }
}
