package pl.Tetris.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import pl.Tetris.model.shape.Shape;
import pl.Tetris.model.shape.ShapeFactory;

import java.util.List;
import java.util.stream.Collectors;

public class Block {

    private List<Rectangle> rectangles;
    private final Color color;
    private int size;

    public Block(int size) {
        Shape shape = ShapeFactory.getRandomShape();
        this.size = size;
        this.color = Color.RED;
        this.setRectangles(
                shape.getStructure().stream()
                        .map(t -> new Rectangle(t[0] * size, t[1] * size,size-1, size-1))
                        .collect(Collectors.toList()));
        this.rectangles.forEach(r -> r.setFill(color));
    }

    public List<Rectangle> getStructure() {
        return rectangles;
    }

    private void setRectangles(List<Rectangle> rectangles) {
        this.rectangles = rectangles;
    }

    public int getSize() {
        return size;
    }
}


