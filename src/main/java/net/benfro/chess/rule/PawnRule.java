package net.benfro.chess.rule;

import com.deliveredtechnologies.rulebook.RuleState;
import com.deliveredtechnologies.rulebook.annotation.*;
import net.benfro.chess.Board;
import net.benfro.chess.Move;
import net.benfro.chess.Piece;
import net.benfro.chess.PieceType;

@Rule
public class PawnRule {
   @Given("board")
   private Board board;

   @Given("move")
   Move move;

   @Result
   private boolean canMove;

   @When
   public boolean when() {
      Piece piece = board.get(move.from);
      return piece.getType() == PieceType.PAWN &&
              (board.get(move.to) == null || board.get(move.to).getColor() != piece.getColor());
   }

   @Then
   public RuleState then() {
      board.doMove(move);
      canMove = true;
      return RuleState.BREAK;
   }
}
