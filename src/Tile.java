public class Tile {
    private final int value;

    /**
     * Constructs the attribute of integer value of the current instance of Tile.
     *
     * @param value Gets an integer value.
     */
    public Tile(int value) {
        this.value = value;
    }

    /**
     * @return the attribute of value of the current instance of Tile.
     */
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