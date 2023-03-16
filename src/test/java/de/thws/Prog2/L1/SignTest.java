package de.thws.Prog2.L1;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class SignTest {
    @Test
    public void testSignOperator(){
        assertEquals(-1, Sign.sign(-5));
        assertEquals(1, Sign.sign(5));
        assertEquals(0, Sign.sign(0));
    }
}
