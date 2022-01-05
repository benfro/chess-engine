package net.benfro.chess;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultGridTest {

   class MyGrid extends DefaultGrid<String> {

      public MyGrid(int colSize, int rowSize) {
         super(colSize, rowSize);
      }

      @Override
      protected List<List<String>> initGrid() {
         List<List<String>> out = Lists.newArrayList();
         for (int i = 0; i < getRowSize(); i++) {
            List<String> row = Lists.newArrayList();
            for (int j = 0; j < getColSize() ; j++) {
               row.add("");
            }
            out.add(row);
         }
         return out;
      }
   }

   DefaultGrid<String> instance;

   @BeforeEach
   void setUp() {
      instance = new MyGrid(3, 2);
   }

   @Test
   void testSetOrigo() {
      instance.setElement("A", 0, 0);
   }

   @Test
   void testSetExtremes() {
      instance.setElement("A", 1, 2);
   }

   @Test
   void testget() {
      instance.setElement("A", 0, 0);
      assertEquals("A", instance.elementAt(0, 0));
   }
}
