package pl.Tetris.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class MeshBoard {

    private Map<Coords, Boolean> mesh = new HashMap<>();

    public MeshBoard(int x, int y) {
        setMesh(x,y);
    }

    public void setMesh(int x, int y) {
        for (int i = 0; i < x; i++)
            for(int j = 0; j < y; j++)
                mesh.put(new Coords(i,j), true);
    }

/*    public Map<Coords, Boolean> getTilesByY(int y) {
        return mesh.entrySet().stream()
                .filter(c -> y == c.getKey().y)
                .map(Map.Entry::getKey)
    }*/

    public boolean isTileFree(int x, int y) {
        Boolean isFree = mesh.get(new Coords(x,y));
        return isFree == null ? false : isFree;
    }

    public void lockMesh(int x, int y) {
        mesh.put(new Coords(x,y), false);
    }

    static class Coords {
        private int x;
        private int y;

        public Coords(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coords coords = (Coords) o;
            return x == coords.x &&
                    y == coords.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
