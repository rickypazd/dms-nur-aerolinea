package Application.UseCases.Queries.Aeronaves.GetAll;

import java.util.List;
import Domain.Model.Aeronaves.Aeronave;
import Domain.Repositories.IAeronaveRepository;
import SharedKernel.mediator.RequestHandler;

public class GetAllAeronaveHandler implements RequestHandler<GetAllAeronaveQuery, List<Aeronave>> {

    private IAeronaveRepository _aeronaveRepository;

    public GetAllAeronaveHandler(IAeronaveRepository aeronaveRepository) {
        this._aeronaveRepository = aeronaveRepository;
    }

    @Override
    public List<Aeronave> handle(GetAllAeronaveQuery request) {
        return _aeronaveRepository.GetAll();
    }
}
