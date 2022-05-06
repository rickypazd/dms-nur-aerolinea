package Application.UseCases.Command.Aeronaves;

import java.util.UUID;

import Domain.Factories.IAeronaveFactory;
import Domain.Model.Aeronaves.Aeronave;
import kernel.core.BussinessRuleValidateExeption;
import kernel.http.HttpStatus;
import kernel.http.Exception.HttpException;
import kernel.mediator.RequestHandler;

public class CrearAeronaveHandler implements RequestHandler<CrearAeronaveCommand, Aeronave> {

    private IAeronaveFactory _aeronaveFactory;

    public CrearAeronaveHandler(IAeronaveFactory aeronaveFactory) {
        this._aeronaveFactory = aeronaveFactory;
    }

    @Override
    public Aeronave handle(CrearAeronaveCommand request) {
        Aeronave aeronaveDto;
        aeronaveDto = _aeronaveFactory.Create(request.matricula);
        return aeronaveDto;

    }

}
