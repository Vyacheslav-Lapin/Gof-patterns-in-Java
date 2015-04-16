package ru.vlapin.builder;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Vyacheslav Lapin (http://vlapin.ru)
 * @version 0.1 (16.04.2015 11:01)
 */
public class SimpleA implements A {

    private String requiredField,
            optionalField;

    private SimpleA(String requiredField) {
        this.requiredField = requiredField;
    }

    public static class Builder implements A.Builder<SimpleA, Builder> {

        private SimpleA simpleA;

        private Builder() {
        }

        private Builder init(SimpleA simpleA) {
            this.simpleA = simpleA;
            return this;
        }

        @Override
        public SimpleA build() {
            try {
                return simpleA;
            } finally {
                simpleA = null;
            }
        }

        @Override
        public Builder setOptionalField(String optionalField) {
            simpleA.optionalField = optionalField;
            return this;
        }
    }

    private static Builder builder;

    public static Builder getBuilder(SimpleA simpleA) {
        if (builder == null)
            builder = new Builder();
        return builder.init(simpleA);
    }

    public static Builder getBuilder(String requiredField){
        return getBuilder(new SimpleA(requiredField));
    }

    protected String[] getFields() {
        return new String[]{getRequiredField(), getOptionalField()};
    }

    public String toString() {
        return Arrays.stream(getFields())
                .filter(x -> x != null)
                .collect(Collectors.joining(", "));
    }

    @Override
    public String getRequiredField() {
        return requiredField;
    }

    @Override
    public String getOptionalField() {
        return optionalField;
    }
}