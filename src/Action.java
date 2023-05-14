public class Action {
    public Action action;
    public Tile tile;
    public Direction direction;
    public Action(Action action) {
        this.action = action;
    }
    public Action(Tile tile) {
        this.tile = tile;
    }
    public Action(Direction direction) {
        this.direction = direction;
    }
    public Action getAction() {
        return action;
    }
    public Tile getTile() {
        return tile;
    }
    public Direction getDirection(Direction direction) {
        return direction;
    }
    public String toString() {
        String down = "down";
        return "Move " + this.tile + " " + this.direction;
    }
}

