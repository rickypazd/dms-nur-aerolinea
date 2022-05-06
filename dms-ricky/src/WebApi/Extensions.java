package WebApi;

import SharedKernel.http.Rest;
import WebApi.Controllers.AeronaveController;

public class Extensions {
    public static void AddControllers() {
        Rest.addController(AeronaveController.class);
        Rest.start(80);
    }
}
