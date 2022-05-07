package Application.UseCases.Command.Aeronaves.Eliminar;

import Domain.Factories.IAeronaveFactory;
import Domain.Model.Aeronaves.Aeronave;
import Domain.Repositories.IAeronaveRepository;
import Domain.Repositories.IUnitOfWork;
import SharedKernel.http.HttpStatus;
import SharedKernel.http.Exception.HttpException;
import SharedKernel.mediator.RequestHandler;

public class EliminarAeronaveHandler implements RequestHandler<EliminarAeronaveCommand, Aeronave> {

    private IAeronaveFactory _aeronaveFactory;
    private IAeronaveRepository _aeronaveRepository;
    private IUnitOfWork _unitOfWork;

    public EliminarAeronaveHandler(IAeronaveFactory aeronaveFactory, IAeronaveRepository aeronaveRepository,
            IUnitOfWork _unitOfWork) {
        this._aeronaveFactory = aeronaveFactory;
        this._aeronaveRepository = aeronaveRepository;
        this._unitOfWork = _unitOfWork;
    }

    @Override
    public Aeronave handle(EliminarAeronaveCommand request) throws HttpException {
        Aeronave aeronave = _aeronaveRepository.FindByKey(request.aeronave.key);
        if (aeronave == null) {
            throw new HttpException(HttpStatus.BAD_REQUEST, "Aeronave no encontrada");
        }
        
        return _aeronaveRepository.Delete(aeronave);

    }

}
