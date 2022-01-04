package net.benfro.chess;

public class Board extends DefaultGrid<Piece> {

   final static int SIZE = 8;

   public Board() {
      super(SIZE, SIZE);
   }

   public void place(Piece piece, String square) {
      setElement(piece, indexOf(square), getColumnIdx(square));
      if (piece != null) {
         piece.setPosition(square);
      }
   }

   private int getColumnIdx(String square) {
      return Integer.parseInt(square.substring(1)) - 1;
   }

   public Piece get(String square) {
      return elementAt(indexOf(square), getColumnIdx(square));
   }

   public boolean isMovePossible(String from, String to) {
      Piece piece = get(from);
      Piece toPiece = get(to);
      if (toPiece == null || toPiece.getType() != piece.getType()) {
         return true;
      }
      return false;
   }

   private int indexOf(String square) {
      String a = "abcdefgh";
      char c = square.charAt(0);
      return a.indexOf(c);
   }

   // Synchronize?
   public void doMove(Move move) {
      Piece piece = get(move.from);
      place(piece, move.to);
      place(null, move.from);
   }
}
