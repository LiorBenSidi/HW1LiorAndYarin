public class Node {
    /*not sure*/
    public String[][] image;

    public Node(String[][] board) {
        this.image = board;
    }
    public State getState(){
        State state = new State(image);
        return state;
    }
    public Action getAction(){
        Action action = new Action();

        return action;
    }
    public Node getParent() {
        Node parent = new Node(image);
        return parent;
    }

    public Node[] expand() {
        return new Node[]{};
        //TODO: We need to think how to use the methods of the class "State" for expending the vertex.
    }
    public int heuristicValue() {

        return 0;
    }
}
