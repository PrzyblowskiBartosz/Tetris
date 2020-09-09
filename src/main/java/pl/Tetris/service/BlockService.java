package pl.Tetris.service;

import javafx.scene.shape.Rectangle;
import pl.Tetris.model.Block;
import pl.Tetris.model.Board;
import pl.Tetris.model.Direction;

import java.util.ArrayList;
import java.util.List;

public class BlockService {

    private Block activeBlock;
    private  List<Block> blockList = new ArrayList<>();

    public BlockService() {
    }

    public void setActiveBlock(Block activeBlock) {
        this.activeBlock = activeBlock;
    }

    public void addBlock(Block block) {
        if (block != null)
            this.blockList.add(block);
    }

    public Block getActiveBlock() {
        return activeBlock;
    }

    public List<Block> getBlockList() {
        return blockList;
    }

    public Block createNewBlock() {
        Block newBlock = new Block(Board.TILE);
        addBlock(newBlock);
        setActiveBlock(newBlock);
        return newBlock;
    }

    private void checkBlockState() {

    }
}
