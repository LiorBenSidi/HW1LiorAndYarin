/**
 * The Action class represents an action in "Sliding Puzzle" game, specifically the movement of a tile to an empty space.
 * In addition, it used to return a string representation of an action in the format "Move {tile value} {direction}".
 */
public class Action {
    private final Tile tile;
    private final Direction direction;

    public Action(Tile tile, Direction direction) {
        this.tile = tile;
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    /**
     * @return A string representation of the action in the format "Move {tile value} {direction}".
     */
    public String toString() {
        if(direction == Direction.UP) {
            return "Move " + tile.getValue() + " up";
        } else if(direction == Direction.DOWN) {
            return "Move " + tile.getValue() + " down";
        } else if(direction == Direction.RIGHT) {
            return "Move " + tile.getValue() + " right";
        } else {
            return "Move " + tile.getValue() + " left";
        }
    }
}

