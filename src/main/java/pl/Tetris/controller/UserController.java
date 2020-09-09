package pl.Tetris.controller;

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import pl.Tetris.model.Direction;
import pl.Tetris.service.ControlService;

public class UserController {

    private final ControlService controlService;

    public UserController(Scene scene, ControlService controlService) {
        this.controlService = controlService;
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
