package Domain.Factories;

import Domain.Model.Aeronaves.Aeronave;

public class AeronaveFactory implements IAeronaveFactory {

    public AeronaveFactory() {

    }

    @Override
    public Aeronave Create(String matricula) {
        return new Aeronave(matricula);
    }

}
