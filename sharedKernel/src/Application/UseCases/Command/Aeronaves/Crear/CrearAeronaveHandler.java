package Application.UseCases.Command.Aeronaves.Crear;

import Domain.Factories.IAeronaveFactory;
import Domain.Model.Aeronaves.Aeronave;
import Domain.Repositories.IAeronaveRepository;
import Domain.Repositories.IUnitOfWork;
import SharedKernel.http.Exception.HttpException;
import SharedKernel.mediator.RequestHandler;

public class CrearAeronaveHandler implements RequestHandler<CrearAeronaveCommand, Aeronave> {

    private IAeronaveFactory _aeronaveFactory;
    private IAeronaveRepository _aeronaveRepository;
    private IUnitOfWork _unitOfWork;

    public CrearAeronaveHandler(IAeronaveFactory aeronaveFactory, IAeronaveRepository aeronaveRepository,
            IUnitOfWork _unitOfWork) {
        this._aeronaveFactory = aeronaveFactory;
        this._aeronaveRepository = aeronaveRepository;
        this._unitOfWork = _unitOfWork;
    }

    @Override
    public Aeronave handle(CrearAeronaveCommand request) throws HttpException {
        Aeronave aeronave = _aeronaveFactory.Create(request.matricula);
        aeronave.eventCreado();

        _aeronaveRepository.Create(aeronave);
        _unitOfWork.commit();
        return aeronave;

    }

}
