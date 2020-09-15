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
                    setFrame(context);
                    return;
                }
                if (now - lastTick > 1000000000) {
                    lastTick = now;
                    setFrame(context);
                }
            }
        }.start();
    }

    private void setFrame(GraphicsContext context) {
        Block activeBlock = blockService.getActiveBlock();
        if (activeBlock == null) {
            Block newBlock = blockService.createNewBlock();
            boardService.addBlock(newBlock);
            blockService.setActiveBlock(newBlock);
        }
        checkPosition(activeBlock);
        fallBlocks();
    }

    private void fallBlocks() {
        for (Block block : blockService.getBlockList())
            controlService.moveBlock(block, Direction.DOWN);
    }

    private void checkPosition(Block block) {
        if (collisionService.isAtTheBottom(block))
            blockService.setActiveBlock(null);
    }

    public static GameService getInstance() {
        return INSTANCE;
    }
}
