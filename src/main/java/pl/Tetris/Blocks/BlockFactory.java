package pl.Tetris.Blocks;

import java.util.Random;

public  class BlockFactory {

    public static Block createBlock(BlockKind kind) {
        return switch (kind) {
            case S -> new Square();
            case R -> new Rectangle();
            case L -> new LBlock();
            case Z -> new ZBlock();
        };
    }

    public static Block getRandomBlock() {
        Random random = new Random();

        return createBlock(BlockKind.S);
    }
}
