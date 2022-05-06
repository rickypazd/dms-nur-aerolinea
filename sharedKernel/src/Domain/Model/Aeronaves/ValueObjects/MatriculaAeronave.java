package Domain.Model.Aeronaves.ValueObjects;

import kernel.core.BussinessRuleValidateExeption;
import kernel.core.ValueObject;
import kernel.rule.StringNotNullOrEmptyRule;

public class MatriculaAeronave extends ValueObject {
    private String value;

    public MatriculaAeronave(String Value) throws BussinessRuleValidateExeption {
        CheckRule(new StringNotNullOrEmptyRule(Value));
        this.value = Value;
    }
    @Override
    public String toString() {
        return value;
    }
}
