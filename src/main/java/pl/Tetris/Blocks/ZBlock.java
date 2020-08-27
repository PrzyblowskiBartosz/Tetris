package pl.Tetris.Blocks;

/*
 * STRUCTURE BLOCK
 *   [X][X][ ][ ]
 *   [ ][X][X][ ]
 */
public class ZBlock extends Block {
    public ZBlock(){
        this.structure = new byte[] {
                1,1,0,0,
                0,1,1,0
        };
    }
}
