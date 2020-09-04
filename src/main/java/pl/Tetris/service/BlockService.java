package pl.Tetris.service;

import pl.Tetris.model.Block;

import java.util.ArrayList;
import java.util.List;

public class LogicService {

    private Block activeBlock;
    public List<Block> blockList = new ArrayList<>();

    public Block getActiveBlock() {
        return activeBlock;
    }

    public List<Block> getBlockList() {
        return blockList;
    }

    public void setActiveBlock(Block activeBlock) {
        this.activeBlock = activeBlock;
    }
}
