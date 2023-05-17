public class Node { /* Contains information about the current state, the parent node,
                    and the action that led to the current state from the parent node. */
    private State state; /* Initialize an instance of "State", named "state". */
    private Node parent; /* Initialize an instance of "Node", named "parent". */
    private Action action   ; /* Initialize an instance of "Action", named "action". */

    public Node(State state, Node parent, Action action) { /** 12 **/
        this.state = state;
        this.parent = parent;
        this.action = action;
    }

    public Node(State state) {
        this.state = state;
    }
    public State getState() { /** 15 **/
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Node getParent() {
        return this.parent;
    }
    public Action getAction(){
        if(action == null){
            return null;
        }else{
            action.toString();
            return this.action;
        }
    }

    public Node[] expand() { /** 20 **/
        State currentState = this.state; // Access the current state from the Node
        Action[] validActions = currentState.actions(); /** 21 **/ // Get the valid actions that can be applied to the current state
        Node[] childNodes = new Node[validActions.length]; // Create an array to store the child nodes
        for (int i = 0; i < validActions.length; i++) { // Generate child nodes by applying each valid action to the current state
            this.action = validActions[i];
            State nextState = currentState.result(action); /** 23 **/
            parent = new Node(this.state);
            Node childNode = new Node(nextState, parent, action);
            childNodes[i] = childNode;
        }
        return childNodes;
    }
    public int heuristicValue() {

        if (this.state.isGoal()) {
            return 0; // If the node's state is the goal state, the heuristic value is 0
        }

        int count = 0;
        Tile[][] currentTiles = this.state.getBoard().getTiles();
        Tile[][] goalTiles = this.state.getBoard().getGoalTiles();

        for (int i = 0; i < currentTiles.length; i++) {
            for (int j = 0; j < currentTiles[i].length; j++) {
                if (currentTiles[i][j].getValue() != goalTiles[i][j].getValue()) {
                    count++; // Increment count for each tile not in the correct position
                }
            }
        }
        return count;

        /*
        boolean firstFlag = true;
        int preCount = 0;
        int count = 0;
        if(this.parent != null && this.childNodes != null) {
            for(int i = 0; i < childNodes.length; i++) {
                for(int j = 0; j < childNodes[i].getState().getBoard().getTiles().length; j++) {
                    for(int k = 0; k < childNodes[i].getState().getBoard().getTiles()[0].length; k++) {
                        if(this.childNodes[i].getState().getBoard().getTiles()[j][k]
                                == this.childNodes[i].getState().getBoard().getGoalTiles()[j][k]) {
                            count++;
                        }
                    }
                }
                if(firstFlag) {
                    preCount = count;
                    firstFlag = false;
                }
                if(preCount > count) {
                    preCount = count;
                }
            }
        }
        this.hu = preCount;

        return preCount;
         */
    }
}
