package SharedKernel.mediator;

import java.util.ArrayList;
import java.util.List;

public class MediatorPlanNotify {
    public static List<NotificationHandler<Notification>> getInstances(Class ctx,
            Class<?> messageType) {
        List<NotificationHandler<Notification>> instances = new ArrayList<>();
        return instances;
    }
}