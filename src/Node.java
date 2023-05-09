public class Node {
    /*not sure*/
    public String[][] board;

    public Node(String[][] vortex) {
        this.board = vortex;
    }
    public State getState(){
        State state = new State(board);
        return state;
    }
    public Action getAction(){
        Action action = new Action();
        return action;
    }
    public Node getParent() {
        Node parent = new Node(board);
        return parent;
    }

    public Node[] expand() {
        String[] arrOfVertex = {};
        return arrOfVertex;
        //TODO: We need to think how to use the methods of the class "State" for expending the vertex.
    }
    public int heuristicValue() {

        return 0;
    }
}
