package Domain.Factories;

import Domain.Model.Aeronaves.Aeronave;
import kernel.core.BussinessRuleValidateExeption;
import kernel.http.Exception.HttpException;

public class AeronaveFactory implements IAeronaveFactory {

    public AeronaveFactory() {

    }

    @Override
    public Aeronave Create(String matricula) {
        return new Aeronave(matricula);
    }

}
