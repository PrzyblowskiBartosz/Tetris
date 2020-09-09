package pl.Tetris.model.shape;

/*
 * STRUCTURE BLOCK
 *  1 [X][X][ ][ ]
 *  0 [ ][X][X][ ]
 *     0  1  2  3
 */
public class ZShape extends Shape {
    public ZShape(){
        this.structure.add(new int[]{0,1});
        this.structure.add(new int[]{1,0});
        this.structure.add(new int[]{1,1});
        this.structure.add(new int[]{0,2});
    }
}
