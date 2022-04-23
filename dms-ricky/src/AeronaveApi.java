import java.util.ArrayList;
import java.util.List;
import Domain.Model.Aeronaves.*;
import kernel.http.HttpStatus;
import kernel.http.Exception.HttpException;
import kernel.http.annotation.*;
import kernel.mediator.Mediator;

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
    public Aeronave getByKey(@PathVariable String key) throws HttpException {
        if (key == null) {
            throw new HttpException(HttpStatus.NOT_FOUND, "INTERNAL_SERVER_ERROR");
        }
        System.out.println("entro getByKey");
        return new Aeronave();
    }

    @PostMapping("/registro")
    public Aeronave register(@RequestBody Aeronave aeronave) {
        aeronave.agregarAsiento(new Asiento(aeronave.getKey(), 1, "primera"));
        aeronave.agregarAsiento(new Asiento(aeronave.getKey(), 2, "primera"));
        return aeronave;
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