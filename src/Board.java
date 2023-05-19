import java.util.Arrays;

public class Board {
    private final Tile[][] tiles;

    /**
     * Constructs a Board object based on a string representation of the board
     *
     * @param strBoard the string representation of the board
     */
    public Board(String strBoard) { // Creates a board(matrix of tiles).
        String[] strBoardSplit = strBoard.split("\\|");
        int numOfCol = strBoardSplit[0].split(" ").length;
        int numOfRow = strBoardSplit.length;
        this.tiles = new Tile[numOfRow][numOfCol];
        for(int i = 0; i < numOfRow; i++) {
            String[] strBoardSecondSplit = strBoardSplit[i].split(" ");
            for(int j = 0; j < strBoardSecondSplit.length; j++) {
                String titleValue = strBoardSecondSplit[j];
                if(titleValue.equals("_")) {
                    tiles[i][j] = new Tile(0);
                } else {
                    tiles[i][j] = new Tile(Integer.parseInt(titleValue));
                }
            }
        }
    }

    /**
     * Constructs a Board object based on a 2D array of tiles
     *
     * @param tiles the 2D array of tiles representing the board
     */
    public Board(Tile[][] tiles) {
        this.tiles = tiles;
    }

    /**
     * Retrieves the goal tiles, representing the target board configuration
     *
     * @return the 2D array of tiles representing the goal tiles
     */
    public Tile[][] getGoalTiles() { // Gets the "Target Board".
        Tile[][] tiles = this.tiles;
        int numRows = tiles.length;
        int numCols = tiles[0].length;
        Tile[][] goalTiles = new Tile[numRows][numCols];
        int value = 1;
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                goalTiles[i][j] = new Tile(value);
                value++;
            }
        }
        goalTiles[numRows - 1][numCols - 1] = new Tile(Tile.getEmptyValue());

        return goalTiles;
    }

    /**
     * pull off the current tiles of the board.
     *
     * @return the 2D array of tiles representing the current board
     */
    public Tile[][] getTiles() {
        return this.tiles;
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
