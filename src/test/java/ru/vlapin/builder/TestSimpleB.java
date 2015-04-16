package ru.vlapin.builder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Vyacheslav Lapin (http://vlapin.ru/)
 * @version 0.1 (16.04.2015 10:50).
 */
public class TestSimpleB {

    @Test
    public void testGetBuilder() throws Exception {

        assertEquals(
                "Мама мыла раму, но делала это, спустя рукава, да и вообще - халтурила!",
                SimpleB.getBuilder("Мама мыла раму", "спустя рукава")
                        .setOptionalField("но делала это")
                        .setChildrenOptionalField("да и вообще - халтурила!")
                        .build().toString());

        assertEquals(
                "Мама мыла раму, но делала это, спустя рукава, да и вообще - халтурила!",
                SimpleB.getBuilder("Мама мыла раму", "спустя рукава")
                        .setOptionalField("но делала это")
                        .setChildrenOptionalField("да и вообще - халтурила!")
                        .build().toString());
    }
}