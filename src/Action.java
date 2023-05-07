public class Action {
    public int tile;

    public String toString() {
        for(EnumDirection direction : EnumDirection.values()) {

        }
        EnumDirection direction = EnumDirection.UP;
        String down = "down";
        System.out.println(direction);
        return "Move " + this.tile + " " + down;
    }
}