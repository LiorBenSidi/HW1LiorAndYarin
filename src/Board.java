import java.util.Arrays;

public class Board {
    public String strBoard;
    Board(String strBoard) {
        this.strBoard = "7 5 4|_ 3 2|8 1 6";
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Board)) {
            return false;
        }
        Board board = (Board) other;
        return Arrays.deepEquals(tiles, board.tiles);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(tiles);
    }
}
