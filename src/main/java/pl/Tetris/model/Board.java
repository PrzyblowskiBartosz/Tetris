package pl.Tetris.model;

import javafx.scene.Scene;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;


public class Board {
    public static final int TILE = 20;

    private int x;
    private int y;
    private MeshBoard mesh;

    private final Pane pane;
    private Scene scene;

    public Board() {
        this.pane = new Pane();
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setMesh(int x, int y) {
        this.mesh = new MeshBoard(x,y);
    }

    protected void setScene(int x, int y){
        this.scene = new Scene(this.pane, x*TILE + 150, y*TILE);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Scene getScene() {
        return scene;
    }

    public Pane getPane() {
        return pane;
    }

    public MeshBoard getMesh() {
        return mesh;
    }

    public static BoardBuilder getBuilder() {
        return new BoardBuilder();
    }

    public static class BoardBuilder {
        private int x;
        private int y;

        private Board board;

        public BoardBuilder withXSide(int x) {
            this.x = x;
            return this;
        }

        public BoardBuilder withYSide(int y) {
            this.y = y;
            return this;
        }

        public Board build(){
            this.board = new Board();
            board.setX(x);
            board.setY(y);
            board.setMesh(x, y);
            board.setScene(x, y);
            return this.board;
        }

        public void prepareBoard(Board board){
            addSeparatedLine(board);
            addScoreText(board);
            addLevelText(board);
        }

        private void addSeparatedLine(Board board) {
            Line line = new Line(board.getX()*TILE, 0, board.getX()*TILE, board.getY()*TILE);
            line.setFill(Color.BLACK);
            board.getPane().getChildren().add(line);
        }

        private void addScoreText(Board board) {
            Text score = new Text("Score: ");
            score.setStyle("-fx-font: 20 arials;");
            score.setY(50);
            score.setX(board.getX()*TILE + 5);
            board.getPane().getChildren().add(score);
        }

        private void addLevelText(Board board) {
            Text level = new Text("Lines:");
            level.setStyle("-fx-font: 20 arials;");
            level.setY(100);
            level.setX(board.getX()*TILE + 5);
            level.setFill(Color.GREEN);
            board.getPane().getChildren().add(level);
        }

        public Board getBoard() {
            return board;
        }
    }
}
