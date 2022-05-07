public class App {
    public static void main(String[] args) throws Exception {
        ConfigureServices();
    }

    public static void ConfigureServices() {

        SharedKernel.Extensions.AddKernel();
        Infraestructure.Extensions.AddInfraestructure();
        WebApi.Extensions.AddControllers();
    }
}