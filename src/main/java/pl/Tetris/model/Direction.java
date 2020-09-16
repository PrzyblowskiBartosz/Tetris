package pl.Tetris.model;

import pl.Tetris.controller.BlockController;

public enum Direction {
    RIGHT(block -> {block.getStructure().forEach(rectangle -> rectangle.setX(rectangle.getX() + block.getSize()));}),
    LEFT(block -> {block.getStructure().forEach(rectangle -> rectangle.setX(rectangle.getX() - block.getSize()));}),
    DOWN(block -> {block.getStructure().forEach(rectangle -> rectangle.setY(rectangle.getY() + block.getSize()));});

    public final BlockController blockController;

    Direction(BlockController blockController) {
        this.blockController = blockController;
    }

    public void move(Block block) {
        blockController.moveBlock(block);
    }
}
