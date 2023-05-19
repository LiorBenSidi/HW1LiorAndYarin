public class State {
    //public Tile[][] tiles;
    private Board board;
    //public Action[] arrOfPossibleActions;
    //public State(Tile[][] tiles) {
      //  this.tiles = tiles;
    //}
    public State(Board board) { /** 8 **/
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public boolean isGoal() { /** 16 **/ // להשוות את הboard עם הלוח מטרה באמצעות מעבר על כל אחד מהאריחים
        Tile[][] goalTiles = board.getGoalTiles(); /** 17 **/
        Tile[][] tiles = board.getTiles();

        // Compare the values of tiles with the goalTiles array.
        for(int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles[i].length; j++) {
                if(tiles[i][j].getValue() != (goalTiles[i][j]).getValue()) {
                    return false; // Found a tile that doesn't match the goal configuration.
                }
            }
        }
        return true; // All tiles match the goal configuration.
    }

    public Action[] actions() { /** 22 **/

        Tile[][] tiles = board.getTiles();
        Action[] possibleActions = new Action[4];
        int count = 0;
        boolean isEmptyTile;

        // Find the position of the empty tile.
        int emptyRow = 0;
        int emptyCol = 0;
        int numOfRow = tiles.length;
        int numOfCol = tiles[0].length;
        for (int i = 0; i < numOfRow; i++) {
            isEmptyTile = false;
            for (int j = 0; j < numOfCol && !isEmptyTile; j++) {
                if (tiles[i][j].getValue() == Tile.getEmptyValue()) {
                    emptyRow = i;
                    emptyCol = j;
                    isEmptyTile = true;
                }
            }
        }

        // Generate possible actions based on the position of the empty tile
        boolean colFlag = true;
        boolean rowFlag = true;
        if (numOfRow == 1) {
            if (emptyCol == 0) {
                possibleActions[count] = new Action(tiles[emptyRow][emptyCol+1] ,Direction.LEFT);
                count++;
                rowFlag = false;
            } else if (emptyCol == numOfCol - 1) { //not necessary
                possibleActions[count] = new Action(tiles[emptyRow][emptyCol - 1],Direction.RIGHT);
                count++;
                rowFlag = false;
            } else {
                possibleActions[count] = new Action(tiles[emptyRow][emptyCol - 1], Direction.RIGHT);
                count++;
                possibleActions[count] = new Action(tiles[emptyRow][emptyCol+1], Direction.LEFT);
                count++;
                rowFlag = false;
            }
        }

        if (numOfCol == 1) {
            if (emptyRow == 0) {
                possibleActions[count] = new Action(tiles[emptyRow + 1][emptyCol], Direction.UP);
                count++;
                colFlag = false;
            } else if (emptyRow == numOfRow - 1) { //not necessary
                possibleActions[count] = new Action(tiles[emptyRow - 1][emptyCol], Direction.DOWN);
                count++;
                colFlag = false;
            } else {
                possibleActions[count] = new Action(tiles[emptyRow + 1][emptyCol], Direction.UP);
                count++;
                possibleActions[count] = new Action(tiles[emptyRow - 1][emptyCol], Direction.DOWN);
                count++;
                colFlag = false;
            }
        }

        if (emptyRow == 0 && rowFlag) {
            if (emptyCol == 0) {
                possibleActions[count] = new Action(tiles[emptyRow + 1][emptyCol], Direction.UP);
                count++;
                possibleActions[count] = new Action(tiles[emptyRow][emptyCol+1], Direction.LEFT);
                count++;
                colFlag = false;
            } else if (emptyCol == numOfCol - 1) {
                possibleActions[count] = new Action(tiles[emptyRow + 1][emptyCol], Direction.UP);
                count++;
                possibleActions[count] = new Action(tiles[emptyRow][emptyCol - 1],Direction.RIGHT);
                count++;
                colFlag = false;
            } else {
                possibleActions[count] = new Action(tiles[emptyRow + 1][emptyCol], Direction.UP);
                count++;
                possibleActions[count] = new Action(tiles[emptyRow][emptyCol - 1],Direction.RIGHT);
                count++;
                possibleActions[count] = new Action(tiles[emptyRow][emptyCol+1], Direction.LEFT);
                count++;
                colFlag = false;
            }
        }

        if ((emptyRow == numOfRow - 1) && rowFlag) {
            if (emptyCol == 0) {
                possibleActions[count] = new Action(tiles[emptyRow - 1][emptyCol], Direction.DOWN);
                count++;
                possibleActions[count] = new Action(tiles[emptyRow][emptyCol+1], Direction.LEFT);
                count++;
                colFlag = false;
            } else if (emptyCol == numOfCol - 1) {
                possibleActions[count] = new Action(tiles[emptyRow - 1][emptyCol], Direction.DOWN);
                count++;
                possibleActions[count] = new Action(tiles[emptyRow][emptyCol - 1],Direction.RIGHT);
                count++;
                colFlag = false;
            } else {
                possibleActions[count] = new Action(tiles[emptyRow - 1][emptyCol], Direction.DOWN);
                count++;
                possibleActions[count] = new Action(tiles[emptyRow][emptyCol - 1],Direction.RIGHT);
                count++;
                possibleActions[count] = new Action(tiles[emptyRow][emptyCol+1], Direction.LEFT);
                count++;
                colFlag = false;
            }
        }

        if (emptyRow > 0 && emptyRow < numOfRow - 1) {
            if (emptyCol == 0) {
                possibleActions[count] = new Action(tiles[emptyRow + 1][emptyCol], Direction.UP);
                count++;
                possibleActions[count] = new Action(tiles[emptyRow - 1][emptyCol], Direction.DOWN);
                count++;
                possibleActions[count] = new Action(tiles[emptyRow][emptyCol+1], Direction.LEFT);
                count++;
            } else if (emptyCol == numOfCol - 1) {
                possibleActions[count] = new Action(tiles[emptyRow + 1][emptyCol], Direction.UP);
                count++;
                possibleActions[count] = new Action(tiles[emptyRow - 1][emptyCol], Direction.DOWN);
                count++;
                possibleActions[count] = new Action(tiles[emptyRow][emptyCol - 1],Direction.RIGHT);
                count++;
            } else {
                possibleActions[count] = new Action(tiles[emptyRow + 1][emptyCol], Direction.UP);
                count++;
                possibleActions[count] = new Action(tiles[emptyRow - 1][emptyCol], Direction.DOWN);
                count++;
                possibleActions[count] = new Action(tiles[emptyRow][emptyCol+1], Direction.LEFT);
                count++;
                possibleActions[count] = new Action(tiles[emptyRow][emptyCol - 1],Direction.RIGHT);
                count++;
            }
        }
        // Create a new array with the correct size and copy the actions
        Action[] actionsArray = new Action[count];
        for (int i = 0; i < count; i++) {
            actionsArray[i] = possibleActions[i];
        }
        return actionsArray;
    }

    public State result(Action action) {
        // Create a deep copy of the current state's tiles
        Tile[][] tiles = board.getTiles();
        Tile[][] newTiles = new Tile[tiles.length][tiles[0].length];
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                newTiles[i][j] = new Tile(tiles[i][j].getValue());
            }
        }

        // Find the position of the empty tile
         int emptyRow = 0;
         int emptyCol = 0;
        for (int i = 0; i < newTiles.length; i++) {
            boolean isEmptyTile = false;
            for (int j = 0; j < newTiles[i].length && !isEmptyTile; j++) {
                if (newTiles[i][j].getValue() == Tile.getEmptyValue()) {
                    emptyRow = i;
                    emptyCol = j;
                    isEmptyTile = true;
                }
            }
        }

        // Perform the action based on the direction
        Direction direction = action.getDirection();
        if (direction == Direction.UP) {
            int tempValue = newTiles[emptyRow + 1][emptyCol].getValue();
            newTiles[emptyRow][emptyCol] = new Tile(tempValue);
            newTiles[emptyRow + 1][emptyCol] = new Tile(0);
        } else if (direction == Direction.DOWN) {
            int tempValue = newTiles[emptyRow - 1][emptyCol].getValue();
            newTiles[emptyRow][emptyCol] = new Tile(tempValue);
            newTiles[emptyRow - 1][emptyCol] = new Tile(0);
        } else if (direction == Direction.LEFT) {
            int tempValue = newTiles[emptyRow][emptyCol + 1].getValue();
            newTiles[emptyRow][emptyCol] = new Tile(tempValue);
            newTiles[emptyRow][emptyCol + 1] = new Tile(0);
        } else if (direction == Direction.RIGHT) {
            int tempValue = newTiles[emptyRow][emptyCol - 1].getValue();
            newTiles[emptyRow][emptyCol] = new Tile(tempValue);
            newTiles[emptyRow][emptyCol - 1] = new Tile(0);
        }
        Board newBoard = new Board(newTiles);

        return new State(newBoard); // Create and return the new state
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

