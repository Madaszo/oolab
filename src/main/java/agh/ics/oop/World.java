package agh.ics.oop;

public class World {
    public static void main(String[] args){
        Direction[] directions = change(args);
        run(directions);
    }
    public static  Direction[] change(String[] string){
        Direction[] directions = new Direction[string.length];
        for (int i = 0; i < string.length; i++) {
            switch (string[i]) {
                case "f" -> directions[i] = Direction.FORWARD;
                case "b" -> directions[i] = Direction.BACKWARD;
                case "l" -> directions[i] = Direction.LEFT;
                case "r" -> directions[i] = Direction.RIGHT;
            }
        }
        return directions;
    }
    public static void run(Direction[] directions) {
        System.out.println("Start");
        for (Direction direction : directions) {
            String message = switch (direction) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case RIGHT -> "Zwierzak skręca w prawo";
                case LEFT -> "Zwierzak skręca w lewo";
            };
            System.out.println(message);
        }
        System.out.println("Start");
    }
}
