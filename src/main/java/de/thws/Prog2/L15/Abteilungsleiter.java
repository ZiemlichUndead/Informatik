package de.thws.Prog2.L15;

import java.util.Date;

public class Abteilungsleiter extends Angestellter{
    public Abteilungsleiter(String namen, String vornamen, int id, int gehalt, Date geburtstag) {
        super(namen, vornamen, id, gehalt,  geburtstag);
        gehaltsfaktor = 2;
    }

    public void befoerdern(Angestellter a){
        a.gehaltsfaktor *= 1.1;
    }

}
