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
        assertEquals(4.1887903296220665,Kugelvolumen.berechneKugelvolumen(1));
    }
    @Test
    void testFive(){
        assertEquals(523.5987912027583,Kugelvolumen.berechneKugelvolumen(5));
    }
    @Test
    void testNegativeOne(){
        assertEquals(-4.1887903296220665,Kugelvolumen.berechneKugelvolumen(-1));
    }
}
