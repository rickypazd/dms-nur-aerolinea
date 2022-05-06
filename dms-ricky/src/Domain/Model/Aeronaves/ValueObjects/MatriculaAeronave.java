package Domain.Model.Aeronaves.ValueObjects;

import SharedKernel.core.BussinessRuleValidateExeption;
import SharedKernel.core.ValueObject;
import SharedKernel.rule.StringNotNullOrEmptyRule;

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
