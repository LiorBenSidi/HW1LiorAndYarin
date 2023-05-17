import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Comparator;

public class Search {
    private int expandedNodes;
    private List<Action> result;
    private Status status = Status.UNSOLVED;

    /**
     * Constructs the root node of the game based on an initial board.
     *
     * @param boardString String representing the initial board
     * @return The root node used to search for a solution
     */
    private Node getRoot(String boardString) { /** 4 **/
        // NOTE: This is the only function you need to modify in this class!

        Board rootBoard = new Board(boardString);/** 5 **/
        State rootState = new State(rootBoard); /** 7 **//* Creates an instance of "State", named "rootState",
        that compose an instance of "Board", that gets "boardString". */
        //Node rootParent = null;
        //Action rootAction = null;
        Node root = new Node(rootState, null, null); /** 11 **//* Creates an instance of "Node", named "root". */

        return root; /* Returns the instance of "Node" - "root". */
    }

    /**
     * Performs a Greedy Best First Search, using node heuristic function.
     *
     * @param boardString String representing the initial board
     * @return List of actions which performing them will lead to the the goal state
     */
    public List<Action> search(String boardString) { /** 2 **/
        try { // The Try Catch in java statements allows you to define a block of code to be tested for exceptions (errors) while it is being executed.
            Node root = getRoot(boardString); /**3**/ /** 13 **/  // Creates an instance of "Node"

            Queue<Node> frontier = new PriorityQueue<>(Comparator.comparing(Node::heuristicValue));  // Stores future nodes
            Set<State> enqueued = new HashSet<>();  // Used for duplicate detection
            frontier.add(root);  // Add the root as the first node in the frontier
            enqueued.add(root.getState());  // Mark the root as visited

            while (!frontier.isEmpty()) {
                Node node = frontier.remove();  // Get a node with smallest heuristic value
                if (node.getState().isGoal()) { /** 14 **/
                    result = extractSolution(node);  // Extracting the solution
                    status = Status.SOLVED;
                    return result;
                }
                expandedNodes++;
                Node[] children = node.expand(); /** 19 **/

                for (Node child : children) {  // Iterate over all possible child nodes
                    if (!enqueued.contains(child.getState())) {  // Check for duplication
                        enqueued.add(child.getState());  // Mark the child as visited
                        frontier.add(child);
                    }
                }
            }
            status = Status.UNSOLVABLE;  // Unsolvable board
        } catch (OutOfMemoryError err) {  // Out of memory - probably due to an explosion of the frontier
            status = Status.OUT_OF_MEMORY;
        }
        return null;
    }

    /**
     * Extracts a solution from a given node by iterating backward from the node up to the root.
     * The given node satisfies node.getState().isGoal() == true.
     *
     * @param node Node contains a the goal state
     * @return List of actions to reach the goal state
     */
    private List<Action> extractSolution(Node node) {
        List<Action> actions = new ArrayList<>();
        while (node != null) {  // Iterate backwards until reaching the root
            actions.add(node.getAction());
            node = node.getParent();
        }
        Collections.reverse(actions);  // Reverse the list
        actions.remove(0);
        return actions;
    }

    public Status getStatus() {
        return status;
    }

    public List<Action> getResult() {
        return result;
    }

    public int getExpandedNodes() {
        return expandedNodes;
    }

    public enum Status {
        SOLVED,
        UNSOLVABLE,
        OUT_OF_MEMORY,
        UNSOLVED
    }
}
