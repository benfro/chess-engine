package net.benfro.chess;

import com.google.common.collect.Lists;
import lombok.Synchronized;
import lombok.ToString;

import java.util.List;

@ToString(callSuper = true)
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

   @Synchronized
   public void doMove(Move move) {
      Piece piece = get(move.from);
      place(piece, move.to);
      place(null, move.from);
   }

   @Synchronized
   public void undoMove(Move move) {
      Piece piece = get(move.to);
      place(piece, move.from);
      place(null, move.to);
   }

   public void place(final List<Piece> pieces, final List<String> positions) {
      for (int i = 0; i < pieces.size(); i++) {
         place(pieces.get(i), positions.get(i));
      }
   }

   @Override
   protected List<List<Piece>> initGrid() {
      List<List<Piece>> out = Lists.newArrayList();
      for (int i = 0; i < getRowSize(); i++) {
         List<Piece> row = Lists.newArrayList();
         for (int j = 0; j < getColSize(); j++) {
            row.add(Piece.emptyOf());
         }
         out.add(row);
      }
      return out;
   }
}
