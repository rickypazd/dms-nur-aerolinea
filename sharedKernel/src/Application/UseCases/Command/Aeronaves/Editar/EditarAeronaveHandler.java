package Application.UseCases.Command.Aeronaves.Editar;

import Domain.Factories.IAeronaveFactory;
import Domain.Model.Aeronaves.Aeronave;
import Domain.Repositories.IAeronaveRepository;
import Domain.Repositories.IUnitOfWork;
import SharedKernel.http.HttpStatus;
import SharedKernel.http.Exception.HttpException;
import SharedKernel.mediator.RequestHandler;

public class EditarAeronaveHandler implements RequestHandler<EditarAeronaveCommand, Aeronave> {

    private IAeronaveFactory _aeronaveFactory;
    private IAeronaveRepository _aeronaveRepository;
    private IUnitOfWork _unitOfWork;

    public EditarAeronaveHandler(IAeronaveFactory aeronaveFactory, IAeronaveRepository aeronaveRepository,
            IUnitOfWork _unitOfWork) {
        this._aeronaveFactory = aeronaveFactory;
        this._aeronaveRepository = aeronaveRepository;
        this._unitOfWork = _unitOfWork;
    }

    @Override
    public Aeronave handle(EditarAeronaveCommand request) throws HttpException {
        Aeronave aeronave = _aeronaveRepository.FindByKey(request.aeronave.key);
        if (aeronave == null) {
            throw new HttpException(HttpStatus.BAD_REQUEST, "Aeronave no encontrada");
        }
        aeronave.matricula = request.aeronave.matricula;
        _aeronaveRepository.Update(aeronave);
        return aeronave;

    }

}
