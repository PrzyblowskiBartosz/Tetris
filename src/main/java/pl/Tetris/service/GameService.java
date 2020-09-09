package pl.Tetris.service;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import pl.Tetris.model.Block;
import pl.Tetris.model.Board;
import pl.Tetris.model.Direction;

public class GameService {

    private final BlockService blockService;
    private final BoardService boardService;
    private final ControlService controlService;

    public GameService(BlockService blockService, BoardService boardService, ControlService controlService) {
        this.blockService = blockService;
        this.boardService = boardService;
        this.controlService = controlService;
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
        if (blockService.getActiveBlock() == null)
            boardService.addBlock(blockService.createNewBlock());

        fallBlock();
    }

    private void fallBlock() {
        for (Block block : blockService.getBlockList())
            controlService.moveBlock(block, Direction.DOWN);
    }
}
