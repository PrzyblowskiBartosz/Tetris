package pl.Tetris.controller;

import javafx.stage.Stage;
import pl.Tetris.service.*;

public class GameController {

    private BoardService boardService = BoardService.getInstance();
    private CollisionService collisionService = CollisionService.getInstance();
    private GameService gameService = GameService.getInstance();

    public GameController(Stage stage) {
        prepareGame(stage);
    }

    private void prepareGame(Stage stage) {
        boardService.setStage(stage);
        setServices();
        setUserController();
    }

    private void setServices() {
        boardService.prepareBoard();
        collisionService.setBoardService(boardService);
    }

    private void setUserController() {
        UserController.getInstance().connectScene(boardService.getBoard().getScene());
    }

    public void start(){
        gameService.startTimer();
    }
}
