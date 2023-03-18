package de.thws.Prog2.L15;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class AbteilungsleiterTest {
    @Test
    void testBefoerderung() {

        Angestellter a1 = new Angestellter("A","1",0,10,new Date(2000,25,7));
        Abteilungsleiter al1 = new Abteilungsleiter("Al","1",3,15,new Date(2000,26,7));
        al1.befoerdern(a1);
        assertEquals(a1.gehaltsfaktor,1.1);
        assertEquals(a1.getGehalt(),11);
    }
}
