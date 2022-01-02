package net.benfro.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultGridTest {

   DefaultGrid<String> instance;

   @BeforeEach
   void setUp() {
      instance = new DefaultGrid<>(3, 2);
   }

   @Test
   void testSetOrigo() {
      instance.setElement("A", 0, 0);
   }

   @Test
   void testSetExtremes() {
      instance.setElement("A", 1, 2);
   }

   @Test
   void testget() {
      instance.setElement("A", 0, 0);
      assertEquals("A", instance.elementAt(0, 0));
   }
}
