package pl.Tetris.service;

import javafx.scene.shape.Rectangle;
import pl.Tetris.model.Block;
import pl.Tetris.model.Board;

import java.util.ArrayList;
import java.util.List;

public class BlockService {

    private static final BlockService INSTANCE = new BlockService();

    private Block activeBlock;
    private  List<Block> blockList = new ArrayList<>();

    private BlockService() {}

    public void setActiveBlock(Block activeBlock) {
        this.activeBlock = activeBlock;
    }

    public void addBlockToBlockList(Block block) {
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
        addBlockToBlockList(newBlock);
        return newBlock;
    }

    public void stopBlock(Block block) {
        if (block != null)
            lockTiles(block);
    }

    private void lockTiles(Block block) {
        block.getStructure().forEach(r -> BoardService.getInstance().lockTile(r));
    }

    public static BlockService getInstance() {
        return INSTANCE;
    }
}
