package pl.Tetris.service;

import javafx.scene.shape.Rectangle;
import pl.Tetris.model.Block;
import pl.Tetris.model.Direction;

import java.util.List;

public class ControlService {

    private BlockService blockService;
    private final CollisionService collisionService;

    public ControlService(CollisionService collisionService, BlockService blockService) {
        this.blockService = blockService;
        this.collisionService = collisionService;
    }

    public void moveBlock(Direction dir) {
        Block activeBlock = blockService.getActiveBlock();

        if (activeBlock == null)
            return;

        if (isMoveAvailable(activeBlock, dir))
            move(activeBlock, dir);
    }

    public void moveBlock(Block block, Direction dir) {
        if (block == null)
            return;

        if (isMoveAvailable(block, dir))
            move(block, dir);

        checkPosition(block);
    }

    private boolean isMoveAvailable(Block block, Direction dir) {
        for (Rectangle r : block.getStructure()) {
            int x = (int) r.getX()/block.getSize();
            int y = (int) r.getY()/block.getSize();

            switch (dir) {
                case RIGHT -> x++;
                case LEFT -> x--;
                case DOWN -> y++;
            }

            if(collisionService.isCollision(x, y))
                return false;
        }

        return true;
    }

    private void move(Block block, Direction dir) {
        switch (dir) {
            case RIGHT -> moveBlockRight(block);
            case DOWN -> moveBlockDown(block);
            case LEFT -> moveBlockLeft(block);
        }
    }

    private void moveBlockRight(Block block) {
        block.getStructure().forEach(r -> r.setX(r.getX() + block.getSize()));
    }

    private void moveBlockLeft(Block block) {
        block.getStructure().forEach(r -> r.setX(r.getX() - block.getSize()));
    }

    private void moveBlockDown(Block block) {
        block.getStructure().forEach(r -> r.setY(r.getY() + block.getSize()));
    }

    private void checkPosition(Block block) {
        if (collisionService.isAtTheBottom(block))

    }

    public void rotateActiveBlock(){
        Block activeBlock = blockService.getActiveBlock();

        if (activeBlock == null)
            return;

        if(isRotateAvailable(activeBlock))
            rotate(activeBlock);
    }

    //TODO refactor isRotateAvailable
    private boolean isRotateAvailable(Block block) {
        List<Rectangle> structure = block.getStructure();
        Rectangle pivot = structure.get(structure.size()-1);

        for (Rectangle r : structure){
            // r - p = v
            int vX = (int) (r.getX() - pivot.getX());
            int vY = (int) (r.getY() - pivot.getY());

            // R * v = vt
            int vtX = -vY;
            int vtY = vX;

            //p + vt = r'
            int rX = vtX + (int) pivot.getX();
            int rY = vtY + (int) pivot.getY();

            int size = block.getSize();
            if (collisionService.isCollision(rX/size, rY/size))
                return false;
        }

        return true;
    }

    private void rotate(Block block) {
        List<Rectangle> structure = block.getStructure();

        for (Rectangle r : structure)
            rotatePart(r, structure.get(structure.size()-1));
    }

    //TODO refactor rotatePart
    private void rotatePart(Rectangle rectangle, Rectangle pivot) {
        int rX = -(int) (rectangle.getY() - pivot.getY()) + (int) pivot.getX();
        int rY = (int) (rectangle.getX() - pivot.getX()) + (int) pivot.getY();

        rectangle.setX(rX);
        rectangle.setY(rY);
    }
}
