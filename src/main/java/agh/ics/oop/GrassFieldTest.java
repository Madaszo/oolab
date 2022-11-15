package agh.ics.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        MoveDirection[] directions = OptionsParser.parse(new String[]{"b","r","l","f","f","f","f"});
        SimulationEngine engine = new SimulationEngine(directions,map,positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(1,1)));
        assertTrue(map.isOccupied(new Vector2d(2,1)));
    }

}
