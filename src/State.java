public class State {
    public String[][] boarddd;
    public State(String[][] boarddd) {
        this.boarddd = boarddd;
    }
    public boolean isGoal() {
        boolean isValid = true;
        if (boarddd[boarddd.length][boarddd[0].length] == "_"){
            for (int i = 0; i < boarddd.length; i++ ){
                for (int j = 0; j < boarddd[0].length; j++){
                    if(!(i == boarddd.length - 1 && j == boarddd[0].length - 2)){
                        if(Integer.parseInt(boarddd[i][j]) < Integer.parseInt(boarddd[i][j+1])){
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
