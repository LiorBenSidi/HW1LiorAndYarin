public class State {
    public Tile[][] tiles;
    private Board board;
    public Action[] arrOfPossibleActions;

    public State(Tile[][] tiles) {
        this.tiles = tiles;
    }

    public boolean isGoal() {
        tiles = board.getTiles();
        /**
        //Prints the board.
        for(int i = 0; i < board.length; i++) {
            System.out.println();
            for(int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
         **/
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
    }
    public Action[] actions() {
        //"7 5 4|_ 3 2|8 1 6"
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
    }
    public State result(Action action) {
        State state = null;
        return state;
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
