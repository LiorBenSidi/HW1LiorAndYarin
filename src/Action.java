public class Action { //"Action" in the game is defined by moving a tile to empty space.
    private final Tile tile;
    private final Direction direction;

    /**
     *
     *
     * @param tile
     * @param direction
     */
    public Action(Tile tile, Direction direction) {
        this.tile = tile;
        this.direction = direction;
    }

    /**
     *
     * @return
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     *
     *
     * @return
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

