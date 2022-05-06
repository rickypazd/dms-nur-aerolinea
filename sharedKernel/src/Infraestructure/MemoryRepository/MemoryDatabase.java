package Infraestructure.MemoryRepository;

import java.util.ArrayList;
import java.util.List;

import Domain.Model.Aeronaves.Aeronave;

public class MemoryDatabase {

    ////DIFERENTE AL INGE
    private static MemoryDatabase _instace;

    public static MemoryDatabase getInstance() {
        if (_instace == null) {
            _instace = new MemoryDatabase();
        }
        return _instace;
    }
    //END
    
    private List<Aeronave> _aeronaves;

    public List<Aeronave> get_aeronaves() {
        return _aeronaves;
    }

    public MemoryDatabase() {
        _aeronaves = new ArrayList<>();
    }
}
