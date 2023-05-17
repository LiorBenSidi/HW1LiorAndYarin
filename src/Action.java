public class Action { //"Action" in the game is defined by moving a tile to empty space.
    private Tile tile;
    private Direction direction;
    public Action(Tile tile, Direction direction) {
        this.tile = tile;
        this.direction = direction;
    }
    public Action(Direction direction) {
        this.direction = direction;
    }
    /*
        public Action(Board board) {
            this.board = board;
        }

        public void setAction(Action action) {
            action.toString();
        }
        public Action getAction() {
            return action;
        }
        public Action(Action action) {
            this.action = action;
        }
        public Action(Tile tile) {
            this.tile = tile;
        }
        public Action(Direction direction) {
            this.direction = direction;
        }
         */
    public Tile getTile() {
        return tile;
    }
    public Direction getDirection() {
        return direction;
    }
    public String toString() {
        return "Move " + tile.getValue() + " " + direction;
    }
}

