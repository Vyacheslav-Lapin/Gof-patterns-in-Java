package ru.vlapin.builder;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Vyacheslav Lapin (http://vlapin.ru/)
 * @version 0.1 (16.04.2015 11:00).
 */
public class SimpleB implements B {

  private final String childrenRequiredField;
  private String childrenOptionalField;

  private A superObject;

  private SimpleB(String childrenRequiredField) {
    this.childrenRequiredField = childrenRequiredField;
  }

  @Override public String getChildrenRequiredField() {
    return childrenRequiredField;
  }

  @Override public String getChildrenOptionalField() {
    return childrenOptionalField;
  }

  @Override public String getRequiredField() {
    return superObject.getRequiredField();
  }

  @Override public String getOptionalField() {
    return superObject.getOptionalField();
  }

  public static class Builder implements B.Builder<SimpleB, Builder> {

    private SimpleB simpleB;
    private A.Builder<?, ?> superBuilder;

    private Builder() {
    }

    private <T extends A, V extends A.Builder<T, V>> Builder init(A.Builder<T, V> superBuilder, SimpleB b) {
      this.superBuilder = superBuilder;
      this.simpleB = b;
      return this;
    }

    @Override
    public Builder setChildrenOptionalField(String childrenOptionalField) {
      simpleB.childrenOptionalField = childrenOptionalField;
      return this;
    }

    @Override
    public SimpleB build() {
      try {
        simpleB.superObject = superBuilder.build();
        return simpleB;
      }
      finally {
        simpleB = null;
      }
    }

    @Override
    public Builder setOptionalField(String optionalField) {
      superBuilder.setOptionalField(optionalField);
      return this;
    }
  }

  private static Builder builder;

  public static Builder getBuilder(String requiredField, String childrenRequiredField) {
    if (builder == null)
      builder = new Builder();
    return builder.init(SimpleA.getBuilder(requiredField), new SimpleB(childrenRequiredField));
  }

  protected String[] getFields() {
    return new String[] {
        getRequiredField(), getOptionalField(), getChildrenRequiredField(), getChildrenOptionalField()};
  }

  @Override
  public String toString() {
    return Arrays.stream(getFields())
        .filter(Objects::nonNull)
        .collect(Collectors.joining(", "));
  }
}
