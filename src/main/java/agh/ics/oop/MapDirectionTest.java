package agh.ics.oop;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MapDirectionTest {
    MapDirection[] mapDirection = new MapDirection[4];
    @BeforeEach
    void setUp(){
        mapDirection[0] = MapDirection.NORTH;
        mapDirection[1] = MapDirection.EAST;
        mapDirection[2] = MapDirection.SOUTH;
        mapDirection[3] = MapDirection.WEST;
    }
    @Test
    void testNext(){
        assertEquals(MapDirection.EAST,mapDirection[0].next());
        assertEquals(MapDirection.SOUTH,mapDirection[1].next());
        assertEquals(MapDirection.WEST,mapDirection[2].next());
        assertEquals(MapDirection.NORTH,mapDirection[3].next());
    }
    @Test
    void testPrevious(){
        assertEquals(MapDirection.WEST,mapDirection[0].previous());
        assertEquals(MapDirection.NORTH,mapDirection[1].previous());
        assertEquals(MapDirection.EAST,mapDirection[2].previous());
        assertEquals(MapDirection.SOUTH,mapDirection[3].previous());
    }



}
