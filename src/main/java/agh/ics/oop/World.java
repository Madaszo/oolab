package agh.ics.oop;

public class World {
    public static void main(String[] args){
        Animal malpa = new Animal();
        System.out.println(malpa);
        MoveDirection[] moveDirections = OptionsParser.parse(new String[]{"f", "f"});
        System.out.println(malpa);
        for(MoveDirection moveDirection: moveDirections){
            malpa.move(moveDirection);
        }
        System.out.println(malpa);
//        Vector2d position1 = new Vector2d(1,2);
//        System.out.println(position1);
//        Vector2d position2 = new Vector2d(-2,1);
//        System.out.println(position2);
//        System.out.println(position1.add(position2));
//        Direction[] directions = change(args);
//        run(directions);
//        MapDirection m = MapDirection.EAST;
//        System.out.println(m);
//        MapDirection m2 = m.next();
//        System.out.println(m2);
//        System.out.println(m2.toUnitVector());
    }
    public static  Direction[] change(String[] string){
        Direction[] directions = new Direction[string.length];
        for (int i = 0; i < string.length; i++) {
            switch (string[i]) {
                case "f" -> directions[i] = Direction.FORWARD;
                case "b" -> directions[i] = Direction.BACKWARD;
                case "l" -> directions[i] = Direction.LEFT;
                case "r" -> directions[i] = Direction.RIGHT;
                default -> directions[i] = Direction.IGNORE;
            }
        }
        return directions;
    }
    public static void run(Direction[] directions) {
        System.out.println("Start");
        for (Direction direction : directions) {
            switch (direction) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tylu");
                case RIGHT -> System.out.println("Zwierzak skreca w prawo");
                case LEFT -> System.out.println("Zwierzak skreca w lewo");
                default -> System.out.print("");
            }
        }
        System.out.println("Start");
    }
}
