package pl.Tetris.service;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import pl.Tetris.model.Block;
import pl.Tetris.model.Board;


public class BoardService {

    private static final BoardService INSTANCE = new BoardService();

    private Stage stage;
    private GraphicsContext graphicsContext;
    private Board board;

    private BoardService() {}

    public void prepareBoard() {
        setBoard(buildBoard());
        setGraphicContext(new Canvas(board.getX(), board.getY()));

        stage.setScene(board.getScene());
        stage.setTitle("TETRIS");
        stage.show();
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    private Board buildBoard() {
         Board newBoard =  Board.getBuilder()
            .withXSide(17)
            .withYSide(30)
            .build();

         Board.getBuilder().prepareBoard(newBoard);
         return newBoard;
    }

    private void setGraphicContext(Canvas canvas) {
        this.graphicsContext = canvas.getGraphicsContext2D();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Board getBoard() {
        return board;
    }

    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }

    public boolean checkTile(int x, int y) {
        return board.getMesh().isTileFree(x,y);
    }

    public void addBlock(Block block){
        board.getPane().getChildren().addAll(block.getStructure());
    }

    public static BoardService getInstance() {
        return INSTANCE;
    }
}

