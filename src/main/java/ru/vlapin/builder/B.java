package ru.vlapin.builder;

/**
 * @author Vyacheslav Lapin (http://vlapin.ru/)
 * @version 0.1 (16.04.2015 10:33).
 */
public interface B extends A {

  String getChildrenRequiredField();

  String getChildrenOptionalField();

  interface Builder<T extends B, V extends Builder<T, V>> extends A.Builder<T, V> {

    V setChildrenOptionalField(String childrenOptionalField);
  }
}
