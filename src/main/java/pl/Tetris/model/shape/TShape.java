package pl.Tetris.model.shape;

/*
 * STRUCTURE BLOCK
 *  1 [X][X][P][ ]
 *  0 [ ][X][ ][ ]
 *     0  1  2  3
 * X - Rectangle part
 * P - Rectangle pivot
 */
public class TShape extends Shape {
    public TShape(){
        this.structure.add(new int[]{0,1});
        this.structure.add(new int[]{1,0});
        this.structure.add(new int[]{1,1});
        this.structure.add(new int[]{2,1});
    }
}
