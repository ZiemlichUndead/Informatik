package de.thws.Prog2.L14;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class KugelvolumenTest {

    @Test
    void testZero(){
        assertEquals(0,Kugelvolumen.berechneKugelvolumen(0));
    }
    @Test
    void testOne(){
        assertEquals(4.189,Kugelvolumen.berechneKugelvolumen(1),0.001);
    }
    @Test
    void testFive(){
        assertEquals(523.599,Kugelvolumen.berechneKugelvolumen(5),0.001);
    }
    @Test
    void testNegativeOne(){
        assertEquals(-4.189,Kugelvolumen.berechneKugelvolumen(-1),0.001);
    }
}
