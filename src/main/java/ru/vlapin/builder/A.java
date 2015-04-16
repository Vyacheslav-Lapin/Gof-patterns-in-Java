package ru.vlapin.builder;

/**
 * @author Vyacheslav Lapin (http://vlapin.ru/)
 * @version 0.1 (16.04.2015 10:06).
 */
public interface A {

    String getRequiredField();

    String getOptionalField();

    interface Builder<T extends A, V extends A.Builder<T, V>> {

        T build();

        V setOptionalField(String optionalField);
    }
}