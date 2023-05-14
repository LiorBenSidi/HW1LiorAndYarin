public class Tile { // Defines the type of "Tile", that we used to build a matrix of(a board).
    private final int value;
    public static final int EMPTY_VALUE = 0;
    public Tile(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tile)) {
            return false;
        }
        Tile tile = (Tile) other;
        return value == tile.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }
}