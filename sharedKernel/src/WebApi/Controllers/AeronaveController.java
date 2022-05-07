package WebApi.Controllers;

import java.util.ArrayList;
import java.util.List;

import Application.Dto.AeronaveDto;
import Application.UseCases.Command.Aeronaves.Crear.CrearAeronaveCommand;
import Application.UseCases.Command.Aeronaves.Editar.EditarAeronaveCommand;
import Application.UseCases.Command.Aeronaves.Eliminar.EliminarAeronaveCommand;
import Application.UseCases.Queries.Aeronaves.GetAll.GetAllAeronaveQuery;
import Application.UseCases.Queries.Aeronaves.GetByKey.GetAeronaveByKeyQuery;
import Domain.Model.Aeronaves.*;
import SharedKernel.http.Exception.HttpException;
import SharedKernel.http.annotation.*;
import SharedKernel.mediator.Mediator;
import SharedKernel.mediator.Request;
import SharedKernel.mediator.Response;

@RestController
@RequestMapping("/aeronave")
public class AeronaveController {

    private Mediator _mediator;

    public AeronaveController(Mediator mediator) {
        this._mediator = mediator;
    }

    @GetMapping("/")
    public Response<List<Aeronave>> getAll() throws HttpException {
        return _mediator.send(new GetAllAeronaveQuery());
    }

    @GetMapping("/{key}")
    public Response<AeronaveDto> getByKey(@PathVariable GetAeronaveByKeyQuery request) throws HttpException {
        return _mediator.send(request);
    }

    @PostMapping("/registro")
    public Response<Aeronave> register(@RequestBody CrearAeronaveCommand aeronave) throws HttpException {
        return _mediator.send(aeronave);
    }

    @PutMapping("/{key}")
    public Response<Aeronave> edit(@RequestBody Aeronave aeronave, @PathVariable EditarAeronaveCommand request)
            throws HttpException {
        request.aeronave.matricula = aeronave.matricula;
        return _mediator.send(request);
    }

    @DeleteMapping("/{key}")
    public Response<Aeronave> delete(@PathVariable EliminarAeronaveCommand request) throws HttpException {
        return _mediator.send(request);
    }
}
