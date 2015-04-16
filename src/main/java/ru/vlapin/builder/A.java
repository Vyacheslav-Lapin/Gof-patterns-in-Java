package ru.vlapin.builder;

/**
 * @author Vyacheslav Lapin (http://vlapin.ru/)
 * @version 0.1 (15.04.2015 12:06).
 */
public interface A {

    String getRequiredField();

    String getOptionalField();

    interface Builder<T extends A, V extends A.Builder<T, V>> {

        T build();

        V setOptionalField(String optionalField);
    }
}