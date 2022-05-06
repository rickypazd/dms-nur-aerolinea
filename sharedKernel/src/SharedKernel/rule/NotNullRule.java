package SharedKernel.rule;

import SharedKernel.core.BussinessRule;

public class NotNullRule implements BussinessRule {

        private Object _value;
        public NotNullRule(Object value)
        {
            _value = value;
        }
        public boolean IsValid()
        {
            return _value != null;
        }

        @Override
        public String Message() {
            return "Object cannot be null";
        }

}
