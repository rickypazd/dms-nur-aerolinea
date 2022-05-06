public class App {
    public static void main(String[] args) throws Exception {
        ConfigureServices();
    }

    public static void ConfigureServices() {
        SharedKernel.Extensions.AddKernel();
        Infraestructure.Extensions.AddInfraestructure();
        Application.Extensions.AddApplication();
        WebApi.Extensions.AddControllers();
    }
}