package de.thws.Prog2.L1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class PunktTest {

    @Test
    void testNormal(){
        testMove(10,10);
    }
    @Test
    void testLowX(){
        testMoveFailing(-10,10);
    }
    @Test
    void testLowY(){
        testMoveFailing(10,-10);
    }
    @Test
    void testHighX(){
        testMoveFailing(2000,10);
    }
    @Test
    void testHighY(){
        testMoveFailing(10,1100);
    }

    void testMoveFailing(int x, int y){
        try {
            testMove(x, y);
            throw new RuntimeException("Exception expected");
        }catch (RuntimeException e){
            assertEquals("Point out of bounds",e.getMessage());
        }
    }

    void testMove(int x, int y){
        Punkt p = new Punkt();
        p.verschiebePunkt(x,y);
        assertEquals(x,p.x);
        assertEquals(y,p.y);
    }

}
