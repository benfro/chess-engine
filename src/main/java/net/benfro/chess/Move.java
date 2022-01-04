package net.benfro.chess;

public class Move {

   public static Move of(String from, String to) {
      return new Move(from, to);
   }

   public final String from;
   public final String to;

   Move(String from, String to) {
      this.from = from;
      this.to = to;
   }

   public boolean isVertical() {
      return getHorizontalDelta(from, to) == 0 && !from.equals(to);
   }

   public boolean isDiagonal() {
      return isEvenStep() && !from.equals(to);
   }

   private boolean isEvenStep() {
      int charDelta = getHorizontalDelta(from, to);
      int numDelta = getVerticalDelta(from, to);
      return charDelta == numDelta;
   }

   private int getHorizontalDelta(String from, String to) {
      String a = "abcdefgh";
      return Math.abs(a.indexOf(to.charAt(0)) - a.indexOf(from.charAt(0)));
   }

   private int getVerticalDelta(String from, String to) {
      return Math.abs(Integer.parseInt(to.substring(1)) - Integer.parseInt(from.substring(1)));
   }

   public boolean isHorizontal() {
      return getVerticalDelta(from, to) == 0 && !from.equals(to);
   }

   public boolean isTwoPlusOne() {
      int verticalDelta = getVerticalDelta(from, to);
      int horizontalDelta = getHorizontalDelta(from, to);
      return (verticalDelta == 2 && horizontalDelta == 1) ^ (verticalDelta == 1 && horizontalDelta == 2);
   }
}
