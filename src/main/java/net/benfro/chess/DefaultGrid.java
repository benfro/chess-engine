package net.benfro.chess;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
public abstract class DefaultGrid<E> {

   @Getter
   private final int colSize;
   @Getter
   private final int rowSize;
   private final List<List<E>> grid;

   public DefaultGrid(int colSize, int rowSize) {
      this.colSize = colSize;
      this.rowSize = rowSize;
      grid = initGrid();
   }

   abstract protected List<List<E>> initGrid();

   public E elementAt(int row, int column) {
      return grid.get(row).get(column);
   }

   public E setElement(E e, int row, int column) {
      return grid.get(row).set(column, e);
   }

   public List<E> getAllElements() {
      List<E> out = Lists.newArrayList();
      for (List<E> l : grid) {
         out.addAll(l);
      }
      return out;
   }

   public void clear() {
      grid.forEach(List::clear);
   }
}

