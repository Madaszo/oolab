package agh.ics.oop;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AnimalTest {
    IWorldMap map = new RectangularMap(4, 4);
    Animal malpa = new Animal(map,new Vector2d(2,2));
    @BeforeEach
    void setUp(){
        map.place(malpa);
    }

    @Test
    void test(){
        String[] s = new String[]{"forward","f", "f", "f", "f", "r","z", "f","f","f", "f", "f"};
        MoveDirection[] moveDirections;
        moveDirections = new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD,
                MoveDirection.FORWARD,MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.IGNORE,
                MoveDirection.FORWARD, MoveDirection.FORWARD,MoveDirection.FORWARD, MoveDirection.FORWARD,
                MoveDirection.FORWARD};
        MoveDirection[] parsed = OptionsParser.parse(s);
        for(int i =0;i<moveDirections.length;i++) assertEquals(moveDirections[i], parsed[i]);
        malpa.massMove( OptionsParser.parse(s));
        Vector2d[] bounds = new Vector2d[2];
        bounds[0] = new Vector2d(0,0);
        bounds[1] = new Vector2d(4,4);
        assertTrue(malpa.isAt(bounds[1]));
        assertEquals(malpa.getDirection(),MapDirection.EAST);
        malpa.massMove(OptionsParser.parse(new String[]{"r"}));
        malpa.massMove(OptionsParser.parse(s));
        assertTrue(malpa.isAt(bounds[0]));
        assertEquals(malpa.getDirection(),MapDirection.WEST);
    }

}
