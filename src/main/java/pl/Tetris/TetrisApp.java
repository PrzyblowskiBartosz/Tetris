package pl.Tetris;


import javafx.application.Application;

import javafx.stage.Stage;
import pl.Tetris.service.BoardService;
import pl.Tetris.controller.GameController;


public class TetrisApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        GameController game = new GameController(stage);
        game.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
