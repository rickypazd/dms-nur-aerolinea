package WebApi.Controllers;

import java.util.ArrayList;
import java.util.List;

import Application.Dto.AeronaveDto;
import Application.UseCases.Command.Aeronaves.CrearAeronaveCommand;
import Application.UseCases.Queries.Aeronaves.GetAeronaveByKeyQuery;
import Domain.Model.Aeronaves.*;
import SharedKernel.http.Exception.HttpException;
import SharedKernel.http.annotation.*;
import SharedKernel.mediator.Mediator;
import SharedKernel.mediator.Response;

@RestController
@RequestMapping("/aeronave")
public class AeronaveController {

    private Mediator _mediator;

    public AeronaveController(Mediator mediator) {
        this._mediator = mediator;
    }

    @GetMapping("/")
    public List<Aeronave> getAll() {
        List<Aeronave> aeronaves = new ArrayList<>();
        // aeronaves.add(new Aeronave());
        // aeronaves.add(new Aeronave());
        return aeronaves;
    }

    @GetMapping("/{key}")
    public Response<AeronaveDto> getByKey(@PathVariable GetAeronaveByKeyQuery request) throws HttpException {
        return _mediator.send(request);
    }

    @PostMapping("/registro")
    public Response<Aeronave> register(@RequestBody CrearAeronaveCommand aeronave) {
        return _mediator.send(aeronave);
    }

    @PutMapping("/{key}")
    public Aeronave edit(@RequestBody Aeronave aeronave, @PathVariable String key) {
        return aeronave;
    }

    @DeleteMapping("/{key}")
    public void delete(@PathVariable String key) {
        System.out.println("entro delete");
    }
}
