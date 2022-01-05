package net.benfro.chess;

import java.util.List;

public class AIPlayer {

   private final Board board;
   private final Color playsAs;

   public AIPlayer(Board board, Color playsAs) {
      this.board = board;
      this.playsAs = playsAs;
   }

   public List<Move> generateMoves() {
      return null;
   }
}
