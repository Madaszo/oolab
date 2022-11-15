package agh.ics.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RunEngineTest {
    RectangularMap map;
    Vector2d[] positions = new Vector2d[2];
    @BeforeEach
    void setUp(){
        map = new RectangularMap(4,4);
        positions[0] = new Vector2d(2,2);
        positions[1] = new Vector2d( 1,1);
    }
    @Test
    void testOutOfBounds(){
        MoveDirection[] directions = OptionsParser.parse(new String[]{"f","b","f","b","f"});
        SimulationEngine engine = new SimulationEngine(directions,map,positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(2,4)));
        assertTrue(map.isOccupied(new Vector2d(1,0)));
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
