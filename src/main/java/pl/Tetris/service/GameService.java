package pl.Tetris.service;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import pl.Tetris.model.Block;
import pl.Tetris.model.Direction;

public class GameService {

    private static final GameService INSTANCE = new GameService();

    private final BlockService blockService = BlockService.getInstance();
    private final ControlService controlService = ControlService.getInstance();
    private final BoardService boardService = BoardService.getInstance();
    private final CollisionService collisionService = CollisionService.getInstance();

    private GameService() {
    }

    public void startTimer() {
        setAnimationContext(boardService.getGraphicsContext());
    }

    private void setAnimationContext(GraphicsContext context) {
        new AnimationTimer() {
            long lastTick = 0;
            @Override
            public void handle(long now) {
                if (lastTick == 0) {
                    lastTick = now;
                    runGame(context);
                    return;
                }
                if (now - lastTick > 1000000000) {
                    lastTick = now;
                    runGame(context);
                }
            }
        }.start();
    }

    private void runGame(GraphicsContext context) {

        if (blockService.getActiveBlock() == null)
            generateBlock();

        checkPosition(blockService.getActiveBlock());

        fallBlocks();
    }

    private void generateBlock() {
        Block newBlock = blockService.createNewBlock();
        boardService.addBlock(newBlock);
        blockService.setActiveBlock(newBlock);
    }

    private void checkPosition(Block block) {
        if (collisionService.isAtTheBottom(block)){
            blockService.stopBlock(block);
            blockService.setActiveBlock(null);
        }
    }

    private void fallBlocks() {
        for (Block block : blockService.getBlockList())
            controlService.moveBlock(block, Direction.DOWN);
    }

    public static GameService getInstance() {
        return INSTANCE;
    }
}
