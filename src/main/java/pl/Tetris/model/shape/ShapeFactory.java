package pl.Tetris.Shape;

import java.util.Random;

public  class ShapeFactory {

    public static Shape getRandomShape() {
        Random random = new Random();
        int n = random.nextInt(4);

        return switch (n) {
            case 3 -> new SShape();
            case 2 -> new RShape();
            case 1 -> new LShape();
            case 0 -> new ZShape();
            default -> getRandomShape();
        };
    }
}
