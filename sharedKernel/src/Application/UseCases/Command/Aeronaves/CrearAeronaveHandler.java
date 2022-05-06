package Application.UseCases.Command.Aeronaves;

import java.util.UUID;

import Domain.Factories.IAeronaveFactory;
import Domain.Model.Aeronaves.Aeronave;
import Domain.Repositories.IAeronaveRepository;
import kernel.core.BussinessRuleValidateExeption;
import kernel.http.HttpStatus;
import kernel.http.Exception.HttpException;
import kernel.mediator.RequestHandler;

public class CrearAeronaveHandler implements RequestHandler<CrearAeronaveCommand, Aeronave> {

    private IAeronaveFactory _aeronaveFactory;
    private IAeronaveRepository _aeronaveRepository;

    public CrearAeronaveHandler(IAeronaveFactory aeronaveFactory, IAeronaveRepository aeronaveRepository) {
        this._aeronaveFactory = aeronaveFactory;
        this._aeronaveRepository = aeronaveRepository;
    }

    @Override
    public Aeronave handle(CrearAeronaveCommand request) {
        Aeronave aeronaveDto;
        aeronaveDto = _aeronaveFactory.Create(request.matricula);
        _aeronaveRepository.Create(aeronaveDto);
        return aeronaveDto;

    }

}
