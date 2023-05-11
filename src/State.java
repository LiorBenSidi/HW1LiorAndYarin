public class State {
    public String[][] board;
    public State(String[][] board) {
        this.board = board;
    }
    public boolean isGoal() {

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
            if (board[board.length][board[0].length].equals("_")){
                for (int i = 0; i < board.length; i++ ){
                    for (int j = 0; j < board[0].length; j++){
                        if(!(i == board.length - 1 && j == board[0].length - 2)){
                            if(Integer.parseInt(board[i][j]) < Integer.parseInt(board[i][j+1])){
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
    public String[] actions() {
        String[] arrOfPossibleActions = {"up", "down", "right", "left"};
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
