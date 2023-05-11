public class Action {
    public int tile;

    public String toString() {
//        for(Direction direction : Direction.values()) {

  //      }
        Direction direction = Direction.UP;
        String down = "down";
    //    System.out.println(direction);
        return "Move " + this.tile + " " + down;
    }
}