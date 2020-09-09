package pl.Tetris.controller;

import javafx.stage.Stage;
import pl.Tetris.service.*;

public class GameController {

    private final BoardService boardService;
    private GameService gameService;
    private BlockService blockService;
    private ControlService controlService;

    public GameController(Stage stage) {
        this.boardService = new BoardService(stage);
        createServices();
        prepareControllers();
    }

    private void createServices() {
        CollisionService collisionService = new CollisionService(boardService);
        this.blockService = new BlockService();
        this.controlService = new ControlService(collisionService, blockService);
        this.gameService = new GameService(blockService, boardService, controlService);
    }

    private void prepareControllers() {
        UserController userController = new UserController(boardService.getBoard().getScene(), controlService);
    }

    public void start(){
        gameService.startTimer();
    }
}
