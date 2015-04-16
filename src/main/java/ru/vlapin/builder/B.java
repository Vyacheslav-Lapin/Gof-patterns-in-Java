package ru.vlapin.builder;

/**
 * @author Vyacheslav Lapin (http://vlapin.ru/)
 * @version 0.1 (15.04.2015 15:33).
 */
public interface B extends A {

    String getChildrenRequiredField(); // ќб€зательное поле

    String getChildrenOptionalField(); // ќстальные пол€ - необ€ательные

    interface Builder<T extends B, V extends Builder<T, V>> extends A.Builder<T, V> {

        V setChildrenOptionalField(String childrenOptionalField);
    }
}