package pl.Tetris.Shape;

/*
 * STRUCTURE BLOCK
 *  1 [X][X][ ][ ]
 *  0 [X][X][ ][ ]
 *     0  1  2  3
 */
public class SShape extends Shape {

    public SShape(){
        this.structure.add(new int[]{0,0});
        this.structure.add(new int[]{0,1});
        this.structure.add(new int[]{1,0});
        this.structure.add(new int[]{1,1});
    }
}
