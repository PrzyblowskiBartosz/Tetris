package pl.Tetris;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pl.Tetris.Shape.ShapeFactory;

public class TetrisApp extends Application {

    public final static int TILE_SIZE = 20;
    public final static int X_BOARD = 340;
    public final static int Y_BOARD = 600;

    private static Pane board = new Pane();
    private static Scene scene = new Scene(board, X_BOARD + 150, Y_BOARD);

    @Override
    public void start(Stage stage) throws Exception {
        prepareBoard();

        Canvas canvas = new Canvas(X_BOARD, Y_BOARD);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        ShapeFactory.getRandomShape();

        Rectangle r = new Rectangle(TILE_SIZE-1, TILE_SIZE-1);

        board.getChildren().add(r);

        stage.setScene(scene);
        stage.setTitle("TETRIS");
        stage.show();


    }

    private void prepareBoard() {
        addSeparatedLine();
        addScoreText();
        addLevelText();
    }

    private void addSeparatedLine() {
        Line line = new Line(X_BOARD, 0, X_BOARD, Y_BOARD);
        line.setFill(Color.BLACK);
        board.getChildren().add(line);
    }

    private void addScoreText() {
        Text score = new Text("Score: ");
        score.setStyle("-fx-font: 20 arials;");
        score.setY(50);
        score.setX(X_BOARD + 5);
        board.getChildren().add(score);
    }

    private void addLevelText() {
        Text level = new Text("Lines:");
        level.setStyle("-fx-font: 20 arials;");
        level.setY(100);
        level.setX(X_BOARD + 5);
        level.setFill(Color.GREEN);
        board.getChildren().add(level);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
