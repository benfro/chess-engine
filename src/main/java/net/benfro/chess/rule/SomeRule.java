package net.benfro.chess.rule;

import net.benfro.chess.Board;
import net.benfro.chess.Piece;
import net.benfro.chess.PieceType;
import org.evrete.dsl.annotation.MethodPredicate;
import org.evrete.dsl.annotation.Rule;
import org.evrete.dsl.annotation.Where;

import static net.benfro.chess.PieceType.PAWN;

public class SomeRule {
   @Rule
   @Where(
           methods = {
                   @MethodPredicate(
                           method = "testMethod1",
                           args = {"$b", "$p", "$to"}
                   )
           }
   )
   public void rule(Board $b, Piece $p, String $to) {
      //$c.setTotal(0.0);
   }

   public boolean testMethod1(Board b, Piece p, PieceType type) {
      return p.getType() == type;
   }

   //@Rule
   //@Where("$i.customer == $c")
   //public void rule2(Customer $c, Invoice $i) {
   //   $c.addToTotal($i.getAmount());
   //}
}
