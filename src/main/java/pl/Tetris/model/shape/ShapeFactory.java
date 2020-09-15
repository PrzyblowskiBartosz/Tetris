package pl.Tetris.model.shape;

import java.util.Random;

public class ShapeFactory {

    public static Shape getRandomShape() {
        Random random = new Random();
        int n = random.nextInt(5);

        return switch (n) {
            case 4 -> new TShape();
            case 3 -> new SShape();
            case 2 -> new RShape();
            case 1 -> new LShape();
            case 0 -> new ZShape();
            default -> getRandomShape();
        };
    }
}
