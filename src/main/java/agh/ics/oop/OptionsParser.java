package agh.ics.oop;

public class OptionsParser {
    public static MoveDirection[] parse(String[] s){
        MoveDirection[] w = new MoveDirection[s.length];
        for(int i = 0; i < s.length; i++){
            w[i] = switch (s[i]){
                case "f", "forward" -> MoveDirection.FORWARD;
                case "b", "backward" -> MoveDirection.BACKWARD;
                case "r", "right" -> MoveDirection.RIGHT;
                case "l", "left" -> MoveDirection.LEFT;
                default -> MoveDirection.IGNORE;
            };
        }
        return w;
    }
}
