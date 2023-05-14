import java.util.Arrays;

public class Board {
    private Tile[][] tiles;
    private String strBoard;
    public Board(Tile[][] tiles) {
        this.tiles = tiles;
    }
    public Board(String strBoard) { //"7 5 4|_ 3 2|8 1 6"
        this.strBoard = strBoard;
        String[] strBoardSplit = strBoard.split("\\|"); //["7 5 4","_ 3 2","8 1 6"]
        for(int i = 0; i < strBoardSplit.length; i++) {
            String[] strBoardSecondSplit = strBoardSplit[i].split(" ");
            this.tiles = new Tile[strBoardSplit.length][strBoardSecondSplit.length];
            for(int j = 0; j < strBoardSecondSplit.length; j++) {
                tiles[i][j] = new Tile(Integer.parseInt(strBoardSecondSplit[j]));
            }
        }
        this.tiles = tiles;
    }
    public Tile[][] getTiles() {
        return tiles;
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
