package net.benfro.chess;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
public class Piece {

   public static Piece kingOf(Color color) {
      return new Piece(color, PieceType.KING);
   }

   public static Piece queenOf(Color color) {
      return new Piece(color, PieceType.QUEEN);
   }

   public static Piece bishopOf(Color color) {
      return new Piece(color, PieceType.BISHOP);
   }

   public static Piece rookOf(Color color) {
      return new Piece(color, PieceType.ROOK);
   }

   public static Piece knightOf(Color color) {
      return new Piece(color, PieceType.KNIGHT);
   }

   public static Piece pawnOf(Color color) {
      return new Piece(color, PieceType.PAWN);
   }

   private final Color color;
   private final PieceType type;
   @Setter
   private String position;
}
