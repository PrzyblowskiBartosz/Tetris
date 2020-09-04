package pl.Tetris.Shape;

import java.util.ArrayList;

/*
 * STRUCTURE BLOCK
 *  1 [X][X][X][X]
 *  0 [ ][ ][ ][ ]
 *     0  1  2  3
 */
public class RShape extends Shape {

    public RShape(){
        this.structure.add(new int[]{0,1});
        this.structure.add(new int[]{1,1});
        this.structure.add(new int[]{2,1});
        this.structure.add(new int[]{3,1});
    }
}
