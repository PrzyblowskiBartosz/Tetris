package pl.Tetris.service;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import pl.Tetris.model.Block;
import pl.Tetris.model.Board;


public class BoardService {

    private final Stage stage;
    private GraphicsContext graphicsContext;

    private Board board;

    public BoardService(Stage stage) {
        this.stage = stage;
        setUp();
    }

    public Board getBoard() {
        return board;
    }

    private void setUp() {
        setBoard(buildBoard());

        Canvas canvas = new Canvas(board.getX(), board.getY());
        this.graphicsContext = canvas.getGraphicsContext2D();

        stage.setScene(board.getScene());
        stage.setTitle("TETRIS");
        stage.show();
    }

    private Board buildBoard() {
         Board newBoard =  Board.getBuilder()
            .withXSide(17)
            .withYSide(30)
            .build();

         Board.getBuilder().prepareBoard(newBoard);
         return newBoard;
    }

    public boolean checkTile(int x, int y) {
        return board.getMesh().isTileFree(x,y);
    }

    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void addBlock(Block block){
        this.board.getPane().getChildren().addAll(block.getStructure());
    }
}

