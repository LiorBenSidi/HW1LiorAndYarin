public class Tile {
    private final int value;
    private static final int EMPTY_VALUE = 0;

    /**
     * Constructor that gets an integer value, and define the attribute of integer value of the current instance of Tile.
     *
     * @param value Gets an integer value.
     */
    public Tile(int value) {
        this.value = value;
    }

    /**
     * @return The attribute of value of the current instance of Tile.
     */
    public int getValue() {
        return value;
    }

    /**
     * @return The attribute of value of the current instance of Tile that represents an empty tile.
     */
    public static int getEmptyValue() {
        return EMPTY_VALUE;
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