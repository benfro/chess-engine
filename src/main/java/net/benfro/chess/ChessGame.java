package net.benfro.chess;

import com.google.common.collect.Lists;
import lombok.Getter;

import java.util.List;

public class ChessGame {

   public static void main(String[] args) {
      ChessGame game = new ChessGame();
      System.out.println(game.board);
      while (true) {

      }
   }

   @Getter
   private final Board board;

   public ChessGame() {
      this.board = new Board();
      reset();
   }

   public void reset() {
      //board.clear();
      List<String> positions = Lists.newArrayList(
              "a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1",
              "a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2",
              "a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8",
              "a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7");
      List<Piece> pieces = setup(Color.WHITE);
      pieces.addAll(setup(Color.BLACK));
      board.place(pieces, positions);
   }

   private List<Piece> setup(Color color) {
      List<Piece> out = Lists.newArrayList();
      out.add(Piece.rookOf(color));
      out.add(Piece.knightOf(color));
      out.add(Piece.bishopOf(color));
      out.add(Piece.kingOf(color));
      out.add(Piece.queenOf(color));
      out.add(Piece.bishopOf(color));
      out.add(Piece.knightOf(color));
      out.add(Piece.rookOf(color));
      for (int i = 0; i < 8; i++) {
         out.add(Piece.pawnOf(color));
      }
      return out;
   }
}
