package net.benfro.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static net.benfro.chess.Color.WHITE;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

   private Board board;
   private Piece piece;

   @BeforeEach
   void setUp() {
      board = new Board();
      piece = Piece.pawnOf(WHITE);
   }

   @Test
   void testGetShouldBeNull() {
      assertNull(board.get("a1"));
   }

   @Test
   void testGetShouldBePawn() {
      board.place(piece, "a1");
      assertEquals(piece, board.get("a1"));
   }

   @Test
   void testShouldGetAnotherPawn() {
      board.place(piece, "b1");
      assertEquals(piece, board.get("b1"));
      assertEquals("b1", piece.getPosition());
   }

   @Test
   void testBoundaries() {
      board.place(piece, "a8");
      assertEquals(piece, board.get("a8"));
   }

   @Test
   void testMovePawn() {
      board.place(piece, "a2");
      assertTrue(board.move("a2", "a3"));
   }

   @Test
   void testByValue() {
      int in = 1;
      assertEquals(2, add(in));
      assertEquals(1, in);

      IntHolder intHolder = new IntHolder(1);
      assertEquals(2, add(intHolder).value);
      assertEquals(2, intHolder.value);
   }

   static class IntHolder {
      public int value;

      public IntHolder(int value) {
         this.value = value;
      }
   }

   private IntHolder add(IntHolder holder) {
      holder.value = holder.value + 1;
      return holder;
   }

   private int add(int first) {
      first = first + 1;
      return first;
   }
}
