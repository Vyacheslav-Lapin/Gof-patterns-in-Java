package ru.vlapin.builder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Vyacheslav Lapin (http://vlapin.ru/)
 * @version 0.1 (16.04.2015 10:16).
 */
public class TestSimpleA {

    @Test
    public void testGetBuilder() throws Exception {

        assertEquals(
                "Мама мыла раму, хотя ей и не нравилось",
                SimpleA.getBuilder("Мама мыла раму")
                        .setOptionalField("хотя ей и не нравилось").build().toString());

        assertEquals(
                "Мама мыла раму, хотя ей и не нравилось",
                SimpleA.getBuilder("Мама мыла раму")
                        .setOptionalField("хотя ей и не нравилось").build().toString());
    }
}