package Infraestructure.MemoryRepository;

import java.util.List;

import Domain.Model.Aeronaves.Aeronave;

public class MemoryDatabase {

    private List<Aeronave> _aeronaves;

    public List<Aeronave> get_aeronaves() {
        return _aeronaves;
    }

    public MemoryDatabase() {

    }
}
