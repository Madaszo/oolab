package agh.ics.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GrassFieldTest {
    GrassField map;
    Vector2d[] positions = new Vector2d[2];
    @BeforeEach
    void setUp(){
        map = new GrassField(10);
        positions[0] = new Vector2d(2,2);
        positions[1] = new Vector2d( 1,1);
    }
    @Test
    void testOnTop(){
        try {
            MoveDirection[] directions = OptionsParser.parse(new String[]{"b", "r", "l", "f", "f", "f", "f"});
            System.out.println(map);
            SimulationEngine engine = new SimulationEngine(directions, map, positions, map);
            engine.run();
            System.out.println(map);
            assertTrue(map.isOccupied(new Vector2d(1, 1)));
            assertTrue(map.isOccupied(new Vector2d(2, 1)));
        }catch (IllegalArgumentException exception){
            System.out.println(exception);
        }
        finally {
            System.out.println(map);
        }
    }

    @Test
    void testPlace(){
        try {
            System.out.println(map);
            positions[1] = new Vector2d(2,2);
            MoveDirection[] directions = OptionsParser.parse(new String[]{});
            SimulationEngine engine = new SimulationEngine(directions,map,positions,map);
            engine.run();
        }catch (IllegalArgumentException exception){
            String expectedMessage = "(2,2) is already taken";
            assertEquals(exception.getMessage(), expectedMessage);
            System.out.println(exception);
        }finally {
            System.out.println(map);
            System.out.println(map.objects);
        }
    }

}
