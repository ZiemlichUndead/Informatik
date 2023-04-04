package de.thws.Prog2.L15.A1;

import java.time.LocalDate;
import java.util.Date;

public class Unternehmen {
    Abteilung[] abteilungen;


    public Unternehmen(Abteilung[] abteilungen) {
        this.abteilungen = abteilungen;
    }


    public static void main(String[] args) {
        Angestellter a1 = new Angestellter("A","1",0,10,new Date(2000,25,7));
        Angestellter a2 = new Angestellter("A","2",1,15,new Date(2000,26,7));
        Abteilungsleiter al1 = new Abteilungsleiter("Al","1",3,15,new Date(2000,26,7));

        Abteilung ab1 = new Abteilung(al1,new Angestellter[]{a1,a2});

        Unternehmen u = new Unternehmen(new Abteilung[]{ab1});
        al1.befoerdern(a1);


    }
}
