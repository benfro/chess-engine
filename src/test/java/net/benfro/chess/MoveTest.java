package net.benfro.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoveTest {

   @BeforeEach
   void setUp() {
   }

   @ParameterizedTest
   @CsvSource(value = {
           "a1,a2,true",
           "a2,a1,true",
           "a2,a2,false",
           "a2,b2,false",
           "a2,b3,false",
   })
   void isVertical(String from, String to, boolean expectedResult) {
      assertEquals(expectedResult, Move.of(from, to).isVertical());
   }

   @ParameterizedTest
   @CsvSource(value = {
           "a1,a2,false",
           "a2,a1,false",
           "a2,a2,false",
           "a2,b2,false",
           "b2,a2,false",
           "a2,b3,true",
           "b3,a2,true",
           "a1,h8,true",
           "a2,b4,false",
           "a1,b3,false",
   })
   void isDiagonal(String from, String to, boolean expectedResult) {
      assertEquals(expectedResult, Move.of(from, to).isDiagonal());
   }

   @ParameterizedTest
   @CsvSource(value = {
           "a1,a2,false",
           "a2,a1,false",
           "a2,a2,false",
           "a2,b2,true",
           "a2,b3,false",
           "a1,b3,false",
   })
   void isHorizontal(String from, String to, boolean expectedResult) {
      assertEquals(expectedResult, Move.of(from, to).isHorizontal());
   }

   @ParameterizedTest
   @CsvSource(value = {
           "a1,a2,false",
           "a2,a1,false",
           "a2,a2,false",
           "a2,b2,false",
           "a2,b3,false",
           "a1,b3,true",
           "a2,c1,true",
           "a2,c3,true",
   })
   void isTwoPlusOne(String from, String to, boolean expectedResult) {
      assertEquals(expectedResult, Move.of(from, to).isTwoPlusOne());
   }
}
