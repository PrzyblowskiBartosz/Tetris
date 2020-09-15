package pl.Tetris.controller;

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import pl.Tetris.model.Direction;
import pl.Tetris.service.ControlService;

import java.util.ResourceBundle;

public class UserController {

    private final static UserController INSTANCE = new UserController();
    private final ControlService controlService = ControlService.getInstance();

    private UserController() {
    }

    public static UserController getInstance() {
        return INSTANCE;
    }

    public void connectScene(Scene scene) {
        setWSADController(scene);
    }

    private void setWSADController(Scene scene) {
        scene.addEventFilter(KeyEvent.KEY_PRESSED, key->{

            switch (key.getCode()) {
                case RIGHT -> controlService.moveBlock(Direction.RIGHT);
                case LEFT -> controlService.moveBlock(Direction.LEFT);
                case DOWN -> controlService.moveBlock(Direction.DOWN);
                case SPACE -> controlService.rotateActiveBlock();
            }
        });
    }
}
