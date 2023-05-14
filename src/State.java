public class State {
    public Tile[][] tiles;
    public Board board;
    //public Action[] arrOfPossibleActions;
    public State(Tile[][] tiles) {
        this.tiles = tiles;
    }
    public State(Board board) {
        this.board = board;
        this.tiles = board.getTiles();
    }

    public Board getBoard() {
        return board;
    }

    public boolean isGoal() {
        Tile[][] goalTiles = board.getGoalTiles();

        // Compare the values of tiles with the goalTiles array.
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                if (!tiles[i][j].equals(goalTiles[i][j])) {
                    return false; // Found a tile that doesn't match the goal configuration.
                }
            }
        }
        return true; // All tiles match the goal configuration.
        /*
        tiles = board.getTiles();

        //Prints the board.
        for(int i = 0; i < board.length; i++) {
            System.out.println();
            for(int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

        boolean isValid = true;
            if (tiles[tiles.length][tiles[0].length].equals("_")){
                for (int i = 0; i < tiles.length; i++){
                    for (int j = 0; j < tiles[0].length; j++){
                        if(!(i == tiles.length - 1 && j == tiles[0].length - 2)){
                            if(tiles[i][j].getValue() < tiles[i][j+1].getValue()){
                                isValid = true;
                            }else{
                                return false;
                            }
                        }else if(isValid){
                            return true;
                        }
                    }
                }
            }else{
                return false;
            }
            return true;
         */
    }
    public Action[] actions() {
        //"7 5 4|_ 3 2|8 1 6"
        Action[] possibleActions = new Action[4];
        int count = 0;
        boolean isEmptyTile;

        // Find the position of the empty tile.
        int emptyRow = -1;
        int emptyCol = -1;
        for (int i = 0; i < tiles.length; i++) {
            isEmptyTile = false;
            for (int j = 0; j < tiles[i].length  && !isEmptyTile; j++) {
                if (tiles[i][j].getValue() == Tile.EMPTY_VALUE) {
                    emptyRow = i;
                    emptyCol = j;
                    isEmptyTile = true;
                }
            }
        }

        // Generate possible actions based on the position of the empty tile
        if (emptyRow > 0) { // Action number 1.
            possibleActions[count] = new Action(Direction.UP);
            count++;
        }
        if (emptyRow < tiles.length - 1) { // Action number 2.
            possibleActions[count] = new Action(Direction.DOWN);
            count++;
        }
        if (emptyCol > 0) { // Action number 3.
            possibleActions[count] = new Action(Direction.LEFT);
            count++;
        }
        if (emptyCol < tiles[0].length - 1) { // Action number 4.
            possibleActions[count] = new Action(Direction.RIGHT);
            count++;
        }

        // Create a new array with the correct size and copy the actions
        Action[] actionsArray = new Action[count];
        for (int i = 0; i < count; i++) {
            actionsArray[i] = possibleActions[i];
        }
        return actionsArray;

        /*
        for(int i = 0; i < tiles.length; i++) {
            for(int j = 0; j <  tiles[0].length; j++) {
                if(tiles[i][j].equals("_")) {
                    if(j == 0 && i == 0) {
                        arrOfPossibleActions = new Action[]{new Action(Direction.LEFT), new Action(Direction.UP)};
                    }
                    if(j == 0 && i != 0 && i != (tiles.length - 1)) {
                        arrOfPossibleActions = new Action[]{new Action(Direction.LEFT), new Action(Direction.UP), new Action(Direction.DOWN)};
                    }
                    if(j == 0 && i == (tiles.length - 1)) {
                        arrOfPossibleActions = new Action[]{new Action(Direction.LEFT), new Action(Direction.DOWN)};
                    }
                    if(i == 0 && j != 0 && j != (tiles[0].length)) {
                        arrOfPossibleActions = new Action[]{new Action(Direction.LEFT), new Action(Direction.RIGHT), new Action(Direction.UP)};
                    }
                }
            }
        }
        return arrOfPossibleActions;
         */
    }
    public State result(Action action) {
        // Create a deep copy of the current state's tiles
        Tile[][] newTiles = new Tile[tiles.length][tiles[0].length];
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                newTiles[i][j] = new Tile(tiles[i][j].getValue());
            }
        }

        // Find the position of the empty tile
        int emptyRow = -1;
        int emptyCol = -1;
        boolean isEmptyTile;
        for (int i = 0; i < newTiles.length; i++) {
            isEmptyTile = false;
            for (int j = 0; j < newTiles[i].length && !isEmptyTile; j++) {
                if (newTiles[i][j].getValue() == Tile.EMPTY_VALUE) {
                    emptyRow = i;
                    emptyCol = j;
                    isEmptyTile = true;
                }
            }
        }

        // Perform the action based on the direction
        Direction direction = action.getDirection();
        int newRow = emptyRow;
        int newCol = emptyCol;
        if (direction == Direction.UP) {
            newRow--;
        } else if (direction == Direction.DOWN) {
            newRow++;
        } else if (direction == Direction.LEFT) {
            newCol--;
        } else if (direction == Direction.RIGHT) {
            newCol++;
        }

        // Swap the empty tile with the adjacent tile
        Tile temp = newTiles[emptyRow][emptyCol];
        newTiles[emptyRow][emptyCol] = newTiles[newRow][newCol];
        newTiles[newRow][newCol] = temp;

        return new State(newTiles); // Create and return the new state

    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof State)) {
            return false;
        }
        State otherState = (State) other;
        return board.equals(otherState.board);
    }

    @Override
    public int hashCode() {
        return board.hashCode();
    }
}
