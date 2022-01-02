package net.benfro.chess;

public class Board {

   final int SIZE = 8;
   private final Piece[][] board;

   public Board() {
      board = new Piece[SIZE][];
      for (int i = 0; i < SIZE; i++) {
         board[i] = new Piece[SIZE];
      }
   }

   public void place(Piece piece, String square) {
      board[indexOf(square)][Integer.parseInt(square.substring(1)) - 1] = piece;
      piece.setPosition(square);
   }

   public Piece get(String square) {
      return board[indexOf(square)][Integer.parseInt(square.substring(1)) - 1];
   }

   public boolean move(String from, String to) {
      Piece piece = get(from);
      Piece toPiece = get(to);
      if (toPiece == null || toPiece.getType() != piece.getType()) {
         return true;
      }
   }

   private int indexOf(String square) {
      String a = "abcdefgh";
      char c = square.charAt(0);
      return a.indexOf(c);
   }
}
