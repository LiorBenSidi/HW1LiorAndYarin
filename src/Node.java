public class Node { /* Contains information about the current state, the parent node,
                    and the action that led to the current state from the parent node. */
    private State state; /* Initialize an instance of "State", named "state". */
    private Node parent; /* Initialize an instance of "Node", named "parent". */
    private Action action; /* Initialize an instance of "Action", named "action". */

    public Node(State state, Node parent, Action action) {
        this.state = state;
        this.parent = parent;
        this.action = action;
    }

    public Node() {
    }
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Node getParent() {
        return parent;
    }
    public Action getAction(){
        action.toString();
        return action;
    }

    public Node[] expand() {
        State currentState = this.state; // Access the current state from the Node
        Action[] validActions = currentState.actions(); // Get the valid actions that can be applied to the current state
        Node[] childNodes = new Node[validActions.length]; // Create an array to store the child nodes
        for (int i = 0; i < validActions.length; i++) { // Generate child nodes by applying each valid action to the current state
            Action action = validActions[i];
            State nextState = currentState.result(action);
            Node childNode = new Node(nextState, this, action);
            childNodes[i] = childNode;
        }
        return childNodes;
    }
    public int heuristicValue() {

        return 0;
    }
}
