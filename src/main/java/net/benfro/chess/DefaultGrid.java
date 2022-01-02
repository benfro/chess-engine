package net.benfro.chess;

import com.google.common.collect.Lists;
import lombok.Getter;

import java.util.List;

public class DefaultGrid<E> {

   @Getter
   private final int colSize;
   @Getter
   private final int rowSize;
   private final List<List<E>> grid;

   public DefaultGrid(int colSize, int rowSize) {
      this.colSize = colSize;
      this.rowSize = rowSize;
      this.grid = Lists.newArrayListWithExpectedSize(rowSize);
      for (int i = 0; i < rowSize; i++) {
         List<E> row = Lists.newArrayListWithExpectedSize(colSize);
         for (int j = 0; j < colSize; j++) {
            row.add(null);
         }
         grid.add(row);
      }
   }

   public E elementAt(int row, int column) {
      return grid.get(row).get(column);
   }

   public E setElement(E e, int row, int column) {
      return grid.get(row).set(column, e);
   }

   public List<E> getAllElements() {
      return null;
   }
}

