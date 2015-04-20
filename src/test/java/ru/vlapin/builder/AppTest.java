package ru.vlapin.builder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Vyacheslav Lapin (http://vlapin.ru/)
 * @version 0.1 (16.04.2015 10:16).
 */
public class AppTest {

    @Test
    public void testSimpleA() throws Exception {

        assertEquals(
                "Quick brown fox, jumps over the lazy dog!",
                SimpleA.getBuilder("Quick brown fox")
                        .setOptionalField("jumps over the lazy dog!").build().toString());

        assertEquals(
                "Quick brown fox, jumps over the lazy dog!",
                SimpleA.getBuilder("Quick brown fox")
                        .setOptionalField("jumps over the lazy dog!").build().toString());
    }

    @Test
    public void testSimpleB() throws Exception {

        assertEquals(
                "Quick, brown fox, jumps over, the lazy dog!",
                SimpleB.getBuilder("Quick", "jumps over")
                        .setOptionalField("brown fox")
                        .setChildrenOptionalField("the lazy dog!")
                        .build().toString());

        assertEquals(
                "Quick, brown fox, jumps over, the lazy dog!",
                SimpleB.getBuilder("Quick", "jumps over")
                        .setOptionalField("brown fox")
                        .setChildrenOptionalField("the lazy dog!")
                        .build().toString());
    }
}