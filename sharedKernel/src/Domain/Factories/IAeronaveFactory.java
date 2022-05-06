package Domain.Factories;

import Domain.Model.Aeronaves.Aeronave;
import kernel.core.BussinessRuleValidateExeption;
import kernel.http.Exception.HttpException;

public interface IAeronaveFactory {

    public Aeronave Create(String matricula) ;
}
