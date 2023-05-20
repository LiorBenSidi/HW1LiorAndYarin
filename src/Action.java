public class Action { /* "Action" in the game is defined by moving a tile to empty space. */
    private final Tile tile;
    private final Direction direction;

    /**
     * Constructs an Action object with the specified tile and direction.
     *
     * @param tile The tile to be moved.
     * @param direction The direction in which the tile will be moved.
     */
    public Action(Tile tile, Direction direction) {
        this.tile = tile;
        this.direction = direction;
    }

    /**
     * @return The direction of the action.
     */
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

