package pl.Tetris.Services;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import pl.Tetris.Shape.Shape;
import pl.Tetris.Shape.ShapeFactory;
import pl.Tetris.TetrisApp;

import java.util.List;
import java.util.stream.Collectors;

public class Block {

    private List<Rectangle> rectangles;
    private Color color;


    public Block() {
        Shape shape = ShapeFactory.getRandomShape();
        this.color = Color.RED;
        this.setRectangles(
                shape.getStructure().stream()
                        .map(t -> new Rectangle(t[0] * TetrisApp.TILE_SIZE, t[1] * TetrisApp.TILE_SIZE,TetrisApp.TILE_SIZE-1, TetrisApp.TILE_SIZE-1))
                        .collect(Collectors.toList()));
        this.rectangles.forEach(r -> r.setFill(color));

    }

    public List<Rectangle> getStructure() {
        return rectangles;
    }

    private void setRectangles(List<Rectangle> rectangles) {
        this.rectangles = rectangles;
    }
}


