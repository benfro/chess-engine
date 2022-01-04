package net.benfro.chess.rule;

import com.deliveredtechnologies.rulebook.FactMap;
import com.deliveredtechnologies.rulebook.NameValueReferableMap;
import com.deliveredtechnologies.rulebook.model.runner.RuleBookRunner;
import net.benfro.chess.Board;
import net.benfro.chess.Color;
import net.benfro.chess.Move;
import net.benfro.chess.Piece;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PawnRuleTest {

   static RuleBookRunner ruleBook;
   NameValueReferableMap facts;
   Board board;

   @BeforeAll
   static void setUpAll() {
      ruleBook = new RuleBookRunner("net.benfro.chess.rule");
   }

   @BeforeEach
   void setUp() {
      facts = new FactMap();
      board = new Board();
   }

   @Test
   void testPawn() {
      Piece piece = Piece.pawnOf(Color.WHITE);
      board.place(piece, "a2");
      facts.setValue("board", board);
      facts.setValue("move", Move.of("a2", "a3"));
      ruleBook.run(facts);
      assertTrue((boolean)ruleBook.getResult().get().getValue());
      assertEquals(piece, board.get("a3"));
   }



}
