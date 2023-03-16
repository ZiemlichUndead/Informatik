package de.thws.Prog2.L1;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class KugelvolumenTest {

    @Test
    void testZero(){
        assertEquals(0,Kugelvolumen.berechneKugelvolumen(0));
    }
    @Test
    void testOne(){
        assertEquals(Math.PI,Kugelvolumen.berechneKugelvolumen(1));
    }
    @Test
    void testFive(){
        assertEquals(0,Kugelvolumen.berechneKugelvolumen(5));
    }
    @Test
    void testNegativeOne(){
        assertEquals(0,Kugelvolumen.berechneKugelvolumen(-1));
    }
}
