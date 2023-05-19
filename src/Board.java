import java.util.Arrays;

public class Board {
    private Tile[][] tiles;
    private Tile[][] goalTiles;
    private String strBoard;
    public Board(String strBoard) { /** 6 **/ //"7 5 4|_ 3 2|8 1 6" // Creates a board(matrix of tiles).
        this.strBoard = strBoard;
        String[] strBoardSplit = strBoard.split("\\|"); //["7 5 4","_ 3 2","8 1 6"]
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

    public Board(Tile[][] tiles) {
        this.tiles = tiles;
    }

    public void printBoard() {
        for(int i = 0; i < tiles.length; i++) {
            System.out.println();
            for(int j = 0; j < tiles[0].length; j++) {
                System.out.print(tiles[i][j]);
            }
            System.out.println();
        }
    }

    public Tile[][] getGoalTiles() { /** 18 **/ // Gets the "Target Board".
        Tile[][] tiles = this.tiles;
        int numRows = tiles.length;
        int numCols = tiles[0].length;
        this.goalTiles = new Tile[numRows][numCols];
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

    public Tile[][] getTiles() { /** 10 **/
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
