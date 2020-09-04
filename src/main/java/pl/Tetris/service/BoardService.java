package pl.Tetris.controller;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pl.Tetris.model.Block;
import pl.Tetris.model.Board;
import pl.Tetris.service.AnimationService;

public class BoardController {

    private final Stage stage;
    private GraphicsContext graphicsContext;
    private Board board;

    public BoardController(Stage stage) {
        this.stage = stage;
        setUp();
    }

    public Board getBoard() {
        return board;
    }

    private void setUp() {
        setBoard(buildBoard());
        prepareBoard(); // CC fix

        Canvas canvas = new Canvas(board.getXSide(), board.getYSide());
        this.graphicsContext = canvas.getGraphicsContext2D();

        UserController userController = new UserController(board.getScene());

        stage.setScene(board.getScene());
        stage.setTitle("TETRIS");
        stage.show();
    }

    private Board buildBoard() {
         return Board.getBuilder()
            .withTileSize(20)
            .withXSide(340)
            .withYSide(600)
            .build();
    }

    private void prepareBoard(){
        addSeparatedLine(this.board);
        addScoreText(this.board);
        addLevelText(this.board);
    }

    public void addSeparatedLine(Board board) {
        Line line = new Line(board.getXSide(), 0, board.getXSide(), board.getYSide());
        line.setFill(Color.BLACK);
        board.getPane().getChildren().add(line);
    }

    public void addScoreText(Board board) {
        Text score = new Text("Score: ");
        score.setStyle("-fx-font: 20 arials;");
        score.setY(50);
        score.setX(board.getXSide() + 5);
        board.getPane().getChildren().add(score);
    }

    private void addLevelText(Board board) {
        Text level = new Text("Lines:");
        level.setStyle("-fx-font: 20 arials;");
        level.setY(100);
        level.setX(board.getXSide() + 5);
        level.setFill(Color.GREEN);
        board.getPane().getChildren().add(level);
    }

    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }

    public void addBlock(Block block){
        this.board.getPane().getChildren().addAll(block.getStructure());
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}

