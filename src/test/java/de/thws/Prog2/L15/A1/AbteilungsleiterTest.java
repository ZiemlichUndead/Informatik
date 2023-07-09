package de.thws.Prog2.L15.A1;

import static org.junit.jupiter.api.Assertions.*;

import de.thws.Prog2.L15.A1.Abteilungsleiter;
import de.thws.Prog2.L15.A1.Angestellter;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;

public class AbteilungsleiterTest {
    @Test
    void testBefoerderung() {

        Angestellter a1 = new Angestellter("A","1",0,10,new Date(2000,25,7));
        Abteilungsleiter al1 = new Abteilungsleiter("Al","1",3,15,new Date(2000,26,7));
        al1.befoerdern(a1);
        assertEquals(a1.gehaltsfaktor,1.1,0.01);
        assertEquals(a1.getGehalt(),11,0.01);

        al1.befoerdern(a1);

        assertEquals(a1.gehaltsfaktor,1.21,0.01);
        assertEquals(a1.getGehalt(),12.1,0.01);

        assertThrows(java.lang.NullPointerException.class, a1::getGehalt);
    }

}
