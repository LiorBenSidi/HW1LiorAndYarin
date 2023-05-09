public class State {
    public boolean isGoal() {


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
