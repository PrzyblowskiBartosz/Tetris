package pl.Tetris.model.shape;

import java.util.ArrayList;
import java.util.List;

/*
* STRUCTURE BLOCK
 *  1 [ ][ ][ ][ ]
 *  0 [ ][ ][ ][ ]
 *     0  1  2  3
*/
public abstract class Shape {
   public List<int[]> structure = new ArrayList<>();
   public List<int[]> getStructure() {
      return structure;
   }
}
