package pl.Tetris.service;

import pl.Tetris.controller.BoardController;
import pl.Tetris.model.Block;

public class GameService {

    private final BoardController boardController;

    public GameService(BoardController boardController) {
        this.boardController = boardController;
    }

    public void start(){
        LogicService logicService = new LogicService();
        AnimationService animationService = new AnimationService(logicService, boardController);
    }
}
