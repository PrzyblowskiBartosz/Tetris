package pl.Tetris.Blocks;

/*
 * STRUCTURE BLOCK
 *   [X][X][X][X]
 *   [ ][ ][ ][ ]
 */
public class Rectangle extends Block {
    public Rectangle(){
        this.structure = new byte[] {
                1,1,1,1,
                0,0,0,0
        };
    }
}
