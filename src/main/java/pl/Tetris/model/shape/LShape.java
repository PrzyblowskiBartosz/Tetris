package pl.Tetris.model.shape;

/*
 * STRUCTURE BLOCK
 *  1 [X][X][X][ ]
 *  0 [ ][ ][X][ ]
 *     0  1  2  3
 */
public class LShape extends Shape {
    public LShape(){
        this.structure.add(new int[]{0, 1});
        this.structure.add(new int[]{1, 1});
        this.structure.add(new int[]{2, 0});
        this.structure.add(new int[]{2, 1});
    }
}
