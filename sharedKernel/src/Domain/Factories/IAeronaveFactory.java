package Domain.Factories;

import Domain.Model.Aeronaves.Aeronave;

public interface IAeronaveFactory {

    public Aeronave Create(String matricula) ;
}
