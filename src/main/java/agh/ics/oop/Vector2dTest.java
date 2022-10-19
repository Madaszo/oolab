package agh.ics.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    Vector2d[] vectors = new Vector2d[3];
    @BeforeEach
    void setUp(){
        vectors[0]= new Vector2d(-1,-1);
        vectors[1]= new Vector2d(1,1);
        vectors[2]= new Vector2d(-1,-1);
    }
    @Test
    void testEquals(){
        assertEquals(vectors[0], vectors[2]);
        assertNotEquals(vectors[0], vectors[1]);
    }
    @Test
    void testToString(){
        assertEquals(vectors[0].toString(),"(-1,-1)");
        assertEquals(vectors[1].toString(),"(1,1)");
    }
    @Test
    void testPrecedes(){
        assertTrue(vectors[0].precedes(vectors[1]));
        assertFalse(vectors[1].precedes(vectors[0]));
    }
    @Test
    void testFollows(){
        assertFalse(vectors[0].follows(vectors[1]));
        assertTrue(vectors[1].follows(vectors[0]));
    }
    @Test
    void testUpperRight(){
        assertEquals(vectors[0].upperRight(vectors[1]),vectors[1]);
        assertEquals(vectors[1].upperRight(vectors[0]), vectors[1]);
    }
    @Test
    void testLowerLeft(){
        assertEquals(vectors[0].lowerLeft(vectors[1]),vectors[0]);
        assertEquals(vectors[1].lowerLeft(vectors[0]), vectors[0]);
    }
    @Test
    void testAdd(){
        assertEquals(vectors[0].add(vectors[1]),new Vector2d(0,0));
        assertEquals(vectors[1].add(vectors[0]), new Vector2d(0,0));
    }
    @Test
    void testSubtract(){
        assertEquals(vectors[0].subtract(vectors[1]),new Vector2d(-2,-2));
        assertEquals(vectors[1].subtract(vectors[0]), new Vector2d(2,2));
    }
    @Test
    void testOpposite(){
        assertEquals(vectors[0].opposite(),vectors[1]);
        assertEquals(vectors[1].opposite(), vectors[0]);
    }
}
