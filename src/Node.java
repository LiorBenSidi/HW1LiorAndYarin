/**
 * The Node class represents a node in a search algorithm for a "Sliding Puzzle" game.
 * It contains information about the state, parent node, and the action that was taken to reach the current node.
 * This class also used to expand the current node by generating child nodes for each valid action.
 * In addition, it used to computes the heuristic value of the node.
 */
public class Node {
    private final State state;
    private final Node parent;
    private final Action action;

    public Node(State state, Node parent, Action action) {
        this.state = state;
        this.parent = parent;
        this.action = action;
    }

    public State getState() {
        return state;
    }

    public Node getParent() {
        return parent;
    }

    public Action getAction() {
        return action;
    }

    /**
     * Expands the current node by generating child nodes for each valid action.
     *
     * @return an array of child nodes.
     */
    public Node[] expand() {
        /* Gets the valid actions that can be applied to the current state. */
        Action[] validActions = state.actions();

        /* Create an array to store the child nodes. */
        Node[] childNodes = new Node[validActions.length];

        /* Generate child nodes by applying each valid action to the current state. */
        for(int i = 0; i < validActions.length; i++) {
            Action action = validActions[i];
            State nextState = state.result(action);
            Node childNode = new Node(nextState, this, action);
            childNodes[i] = childNode;
        }

        return childNodes;
    }

    /**
     * Computes the heuristic value of the node.
     *
     * @return the heuristic value.
     */
    public int heuristicValue() {
        int h1 = calculateHeuristic1();
        int h2 = calculateHeuristic2();

        /* According to a tests we did, we choose to calculate this way: */
        return (int)(0.1 * h1 + 0.9 * h2);
    }

    /**
     * Calculates the heuristic value for the sliding puzzle game.
     * Find the first option for the heuristic value.
     *
     * @return The distance between the current position and the target position of the tile.
     */
    public int calculateHeuristic1() {
        Tile[][] tiles = state.getBoard().getTiles();
        int distance = 0;

        /* Calculate a distance measure that is calculated by taking the sum of distances,
         between the row and column coordinates. */
        for(int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles[i].length; j++) {
                int value = tiles[i][j].getValue();
                if(value != 0) {
                    int RowOfTarget = (value - 1) / tiles.length;
                    int ColOfTarget = (value - 1) % tiles.length;

                    /* Calculate the distance between the current position and the target position of the tile. */
                    if((i - RowOfTarget)<0) {
                        distance += (-1) * (i - RowOfTarget);
                    } else {
                        distance += (i - RowOfTarget);
                    }
                    if((j - ColOfTarget)<0){
                        distance += -1*(j - ColOfTarget);
                    } else {
                        distance += (j - ColOfTarget);
                    }
                }
            }
        }

        return distance;
    }

    /**
     * Calculates the heuristic value for the "sliding puzzle" game.
     * Find the second option for heuristic value.
     *
     * @return The least number of tiles that are not in place compared to the goal board.
     */
    public int calculateHeuristic2(){
        if(this.state.isGoal()) {
            return 0; /* Sets the heuristic value to 0 if the node's state is the goal state. */
        }

        int count = 0;
        Tile[][] currentTiles = state.getBoard().getTiles();
        Tile[][] goalTiles = state.getBoard().getGoalTiles();

        for(int i = 0; i < currentTiles.length; i++) {
            for(int j = 0; j < currentTiles[i].length; j++) {
                if(currentTiles[i][j].getValue() != goalTiles[i][j].getValue()) {
                    count++; /* If a tile isn't in the correct position, increment count. */
                }
            }
        }

        return count;
    }
}

