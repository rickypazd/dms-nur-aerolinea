import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import Application.Dto.AeronaveDto;
import Application.UseCases.Command.Aeronaves.CrearAeronaveCommand;
import Application.UseCases.Queries.Aeronaves.GetAeronaveByKeyQuery;
import Domain.Model.Aeronaves.*;
import kernel.http.HttpStatus;
import kernel.http.Exception.HttpException;
import kernel.http.annotation.*;
import kernel.mediator.Mediator;
import kernel.mediator.Response;

@RestController
@RequestMapping("/aeronave")
public class AeronaveApi {

    private Mediator _mediator;

    public AeronaveApi(Mediator mediator) {
        this._mediator = mediator;
    }

    @GetMapping("/")
    public List<Aeronave> getAll() {
        List<Aeronave> aeronaves = new ArrayList<>();
        aeronaves.add(new Aeronave());
        aeronaves.add(new Aeronave());
        return aeronaves;
    }

    @GetMapping("/{key}")
    public AeronaveDto getByKey(@PathVariable GetAeronaveByKeyQuery request) throws HttpException {
        AeronaveDto aeronaveDto = _mediator.send(request).data;
        return aeronaveDto;
    }

    @PostMapping("/registro")
    public Response<UUID> register(@PathVariable CrearAeronaveCommand aeronave) {
        Response<UUID> key = _mediator.send(aeronave);
        // aeronave.agregarAsiento(new Asiento(aeronave.getKey(), 1, "primera"));
        // aeronave.agregarAsiento(new Asiento(aeronave.getKey(), 2, "primera"));
        return key;
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
