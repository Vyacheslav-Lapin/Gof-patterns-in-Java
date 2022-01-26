package ru.vlapin.builder;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author Vyacheslav Lapin (http://vlapin.ru/)
 * @version 0.1 (16.04.2015 10:16).
 */
class AppTest {

  @Test
  void testSimpleA() {

    for (int i = 0; i < 2; i++)
      assertThat(
          SimpleA.getBuilder("Quick brown fox")
              .setOptionalField("jumps over the lazy dog!").build().toString())
          .isNotNull()
          .isEqualTo("Quick brown fox, jumps over the lazy dog!");
  }

  @Test
  void testSimpleB() {

    for (int i = 0; i < 2; i++)
      assertThat(
          SimpleB.getBuilder("Quick", "jumps over")
              .setOptionalField("brown fox")
              .setChildrenOptionalField("the lazy dog!")
              .build().toString())
          .isNotNull()
          .isEqualTo("Quick, brown fox, jumps over, the lazy dog!");
  }
}
