public class Node { /* Contains information about the current state, the parent node,
                    and the action that led to the current state from the parent node. */
    private State state; /* Initialize an instance of "State", named "state". */
    private Node parent; /* Initialize an instance of "Node", named "parent". */
    private Action action   ; /* Initialize an instance of "Action", named "action". */
    private Node[] childNodes;

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
            Action action = validActions[i];
            State nextState = currentState.result(action); /** 23 **/
            parent = new Node(this.state);
            Node childNode = new Node(nextState, this.parent, action);
            childNodes[i] = childNode;
        }
        this.childNodes = childNodes;
        return childNodes;
    }
    public int heuristicValue() {
        boolean isLowest = false;
        for(int i = 0; i < childNodes.length && !isLowest; i++) {

        }
        return 0;
    }
}
