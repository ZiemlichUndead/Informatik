package de.thws.Prog2.L1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StreckeTest {
    @Test
    void testOrder() {
        Strecke s = new Strecke(7,3);
        assertTrue(s.start<s.end);
    }

    @Test
    void testIntersectBefore() {
        Strecke s1 = new Strecke(5,7);
        Strecke s2 = new Strecke(6,8);
        assertTrue(s1.intersects(s2));
    }
    @Test
    void testIntersectAfter() {
        Strecke s1 = new Strecke(6,8);
        Strecke s2 = new Strecke(5,7);
        assertTrue(s1.intersects(s2));
    }
    @Test
    void testIntersectInner() {
        Strecke s1 = new Strecke(1,10);
        Strecke s2 = new Strecke(5,6);
        assertTrue(s1.intersects(s2));
    }
    @Test
    void testNointersect() {
        Strecke s1 = new Strecke(5,7);
        Strecke s2 = new Strecke(8,10);
        assertFalse(s1.intersects(s2));
    }

    @Test
    void testOutput() {
        Strecke s = new Strecke(0,50);

        int start = s.start;
        int end = s.end;
        int difference = end-start;

        char[] output = s.toString().toCharArray();
        char[] startChars = (start+"").toCharArray();
        char[] endChars = (end+"").toCharArray();


        for (int i = 0;i < startChars.length; i++) {
            assertEquals(startChars[i],output[i]);
        }
        for (int i = 0; i < difference; i++) {
            assertEquals('-',output[i+startChars.length]);
        }
        for (int i = 0;i< endChars.length; i++) {
            assertEquals(endChars[i],output[i+startChars.length+difference]);
        }

    }
}
