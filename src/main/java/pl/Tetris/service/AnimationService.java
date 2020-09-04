package pl.Tetris.service;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import pl.Tetris.controller.BoardController;
import pl.Tetris.model.Block;

public class PhysicsService {
    
    private GraphicsContext context;

    public PhysicsService(GraphicsContext context) {
        this.context = context;
        setAnimationContext(this.context);
    }

    private void setAnimationContext(GraphicsContext context) {
        new AnimationTimer() {
            long lastTick = 0;
            @Override
            public void handle(long now) {
                if (lastTick == 0) {
                    lastTick = now;
                    tick(context);
                    return;
                }
                if (now - lastTick > 1000000000) {
                    lastTick = now;
                    tick(context);
                }
            }
        }.start();
    }

    private void tick(GraphicsContext context) {
        if (!activeBlock) {
            Block block = new Block();
            blockList.add(block);
            board.getChildren().addAll(block.getStructure());
            this.activeBlock = true;
        }
        fallBlock(blockList.get(0));
    }

    private void fallBlock(Block block) {
        block.getStructure().forEach(r -> r.setY(r.getY()+ block.getSize()));
    }
}
