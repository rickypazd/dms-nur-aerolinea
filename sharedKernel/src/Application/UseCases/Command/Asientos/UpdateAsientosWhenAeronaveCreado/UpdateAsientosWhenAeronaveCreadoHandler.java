package Application.UseCases.Command.Asientos.UpdateAsientosWhenAeronaveCreado;

import Domain.Event.AeronaveCreado;
import Domain.Repositories.IAsientoRepository;
import SharedKernel.mediator.Notification;
import SharedKernel.mediator.NotificationHandler;

public class UpdateAsientosWhenAeronaveCreadoHandler implements NotificationHandler<AeronaveCreado> {

    private IAsientoRepository _asientoRepository;

    // private
    public UpdateAsientosWhenAeronaveCreadoHandler(IAsientoRepository asientoRepository) {
        this._asientoRepository = asientoRepository;
    }

    @Override
    public void handle(Notification notification) {
        System.out.println(notification);

    }

}
