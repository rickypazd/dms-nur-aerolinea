package Application.UseCases.Command.Aeronaves;

import java.util.UUID;

import Domain.Factories.IAeronaveFactory;
import Domain.Model.Aeronaves.Aeronave;
import Domain.Repositories.IAeronaveRepository;
import Domain.Repositories.IUnitOfWork;
import SharedKernel.core.BussinessRuleValidateExeption;
import SharedKernel.http.HttpStatus;
import SharedKernel.http.Exception.HttpException;
import SharedKernel.mediator.RequestHandler;

public class CrearAeronaveHandler implements RequestHandler<CrearAeronaveCommand, Aeronave> {

    private IAeronaveFactory _aeronaveFactory;
    private IAeronaveRepository _aeronaveRepository;
    private IUnitOfWork _unitOfWor;

    public CrearAeronaveHandler(IAeronaveFactory aeronaveFactory, IAeronaveRepository aeronaveRepository, IUnitOfWork unitOfWor) {
        this._aeronaveFactory = aeronaveFactory;
        this._aeronaveRepository = aeronaveRepository;
        this._unitOfWor = unitOfWor;
    }

    @Override
    public Aeronave handle(CrearAeronaveCommand request) {
        Aeronave aeronaveDto;
        aeronaveDto = _aeronaveFactory.Create(request.matricula);
        _aeronaveRepository.Create(aeronaveDto);
        _unitOfWor.commit();
        return aeronaveDto;

    }

}
