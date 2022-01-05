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
      assertEquals(Piece.emptyOf(), board.get("a1"));
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
      assertTrue(board.isMovePossible("a2", "a3"));
   }

   @Test
   void testDoMove() {
      board.place(piece, "a2");
      board.doMove(Move.of("a2", "a3"));
      assertNull(board.get("a2"));
      assertEquals(piece, board.get("a3"));
   }


}
