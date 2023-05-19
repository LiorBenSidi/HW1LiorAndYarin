public class Node {
    private final State state;
    private final Node parent;
    private final Action action;

    /**
     * Constructs a Node object with the specified state, parent node, and action
     *
     * @param state the state associated with the current node
     * @param parent the parent node of the current node
     * @param action the action taken to reach the current node from the parent node
     */
    public Node(State state, Node parent, Action action) {
        this.state = state;
        this.parent = parent;
        this.action = action;
    }

    /**
     * Take the state associated with the node.
     *
     * @return the state of the node
     */
    public State getState() {
        return this.state;
    }

    /**
     * Take the parent node of the current node
     *
     * @return the parent node
     */
    public Node getParent() {
        return this.parent;
    }

    /**
     * Draw the action taken to reach the current node from the parent node
     *
     * @return the action taken
     */
    public Action getAction(){
        if(action == null){
            return null;
        } else {
            action.toString();
            return this.action;
        }
    }

    /**
     * Expands the current node by generating child nodes for each valid action
     *
     * @return an array of child nodes
     */
    public Node[] expand() {
        State currentState = this.state; // Access the current state from the Node
        Action[] validActions = currentState.actions(); // Get the valid actions that can be applied to the current state
        Node[] childNodes = new Node[validActions.length]; // Create an array to store the child nodes
        for (int i = 0; i < validActions.length; i++) { // Generate child nodes by applying each valid action to the current state
            Action action =  validActions[i];
            State nextState = currentState.result(action);
            Node parent = new Node(this.state, this.parent, this.action);
            Node childNode = new Node(nextState, parent, action);
            childNodes[i] = childNode;
        }
        return childNodes;
    }

    /**
     * Computes the heuristic value of the node
     *
     * @return the heuristic value
     */
    public int heuristicValue() {
        if (this.state.isGoal()) {
            return 0; // If the node's state is the goal state, the heuristic value is 0.
        }
        int count = 0;
        Tile[][] currentTiles = this.state.getBoard().getTiles();
        Tile[][] goalTiles = this.state.getBoard().getGoalTiles();

        for (int i = 0; i < currentTiles.length; i++) {
            for (int j = 0; j < currentTiles[i].length; j++) {
                if (currentTiles[i][j].getValue() != goalTiles[i][j].getValue()) {
                    count++; // Increment count for each tile that not in the correct position.
                }
            }
        }
        return count;
    }
}
