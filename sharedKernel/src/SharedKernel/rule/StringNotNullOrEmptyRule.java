package SharedKernel.rule;

import SharedKernel.core.BussinessRule;

public class StringNotNullOrEmptyRule implements BussinessRule {

    private String _value;

    public StringNotNullOrEmptyRule(String value) {
        _value = value;
    }

    @Override
    public boolean IsValid() {
        if (_value != null && !_value.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public String Message() {
        return "string cannot be null";
    }
}
