package net.benfro.chess;

import com.google.common.base.Objects;
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

   public static Piece emptyOf() {
      return new Piece(Color.NONE, PieceType.EMPTY);
   }

   private final Color color;
   private final PieceType type;
   @Setter
   private String position;

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Piece piece = (Piece) o;
      return color == piece.color && type == piece.type;
   }

   @Override
   public int hashCode() {
      return Objects.hashCode(color, type);
   }
}
