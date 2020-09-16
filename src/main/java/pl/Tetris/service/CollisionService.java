package pl.Tetris.service;

import javafx.scene.shape.Rectangle;
import pl.Tetris.model.Block;

public class CollisionService {

    private static final CollisionService INSTANCE = new CollisionService();

    private BoardService boardService;

    private CollisionService() {}

    public void setBoardService(BoardService boardService) {
        this.boardService = boardService;
    }

    public boolean isCollision(int x, int y) {
        return !boardService.checkTile(x,y);
    }

    public boolean isAtTheBottom(Block block) {
        for (Rectangle r : block.getStructure())
            if ((int) r.getY()/block.getSize() == boardService.getBoard().getY())
                return true;

        return false;
    }

    public static CollisionService getInstance() {
        return INSTANCE;
    }
}
