package ru.vlapin.builder;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Vyacheslav Lapin (http://vlapin.ru/)
 * @version 0.1 (15.04.2015 15:19).
 */
public class SimpleB implements B {

    private SimpleB(String childrenRequiredField) {
        this.childrenRequiredField = childrenRequiredField;
    }

    private String childrenRequiredField,
            childrenOptionalField;

    @Override
    public String getChildrenRequiredField() {
        return childrenRequiredField;
    }

    @Override
    public String getChildrenOptionalField() {
        return childrenOptionalField;
    }

    private A _super;

    @Override
    public String getRequiredField() {
        return _super.getRequiredField();
    }

    @Override
    public String getOptionalField() {
        return _super.getOptionalField();
    }

    public static class Builder implements B.Builder<SimpleB, Builder> {

        private SimpleB b;
        private A.Builder superBuilder;

        private Builder() {
        }

        private <T extends A, V extends A.Builder<T, V>> Builder init(A.Builder<T, V> superBuilder, SimpleB b) {
            this.superBuilder = superBuilder;
            this.b = b;
            return this;
        }

        @Override
        public Builder setChildrenOptionalField(String childrenOptionalField){
            b.childrenOptionalField = childrenOptionalField;
            return this;
        }

        @Override
        public SimpleB build() {
            try {
                b._super = superBuilder.build();
                return b;
            } finally {
                b = null;
            }
        }

        @Override
        public Builder setOptionalField(String optionalField) {
            superBuilder.setOptionalField(optionalField);
            return this;
        }
    }

    private static Builder builder;

    public static Builder getBuilder(A.Builder aBuilder, SimpleB b){
        if (builder == null)
            builder = new Builder();
        return builder.init(aBuilder, b);
    }

    public static Builder getBuilder(String requiredField, String childrenRequiredField) {
        return getBuilder(SimpleA.getBuilder(requiredField), new SimpleB(childrenRequiredField));
    }

    protected String[] getFields(){
        return new String[]{
                getRequiredField(), getOptionalField(), getChildrenRequiredField(), getChildrenOptionalField()};
    }

    public String toString() {
        return Arrays.stream(getFields())
                .filter(x -> x != null)
                .collect(Collectors.joining(", "));
    }
}