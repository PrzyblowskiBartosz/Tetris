package pl.Tetris.Blocks;

/*
 * STRUCTURE BLOCK
 *   [X][X][X][ ]
 *   [X][ ][ ][ ]
 */
public class LBlock extends Block {
    public LBlock(){
        this.structure = new byte[] {
                1,1,1,0,
                1,0,0,0
        };
    }
}
