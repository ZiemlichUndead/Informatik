package de.thws.Prog2.L15;

import java.util.Date;

public class Angestellter {

    public String namen, vornamen;
    public int id;
    public int gehalt;
    public double gehaltsfaktor;
    public Date geburtstag;

    public Angestellter(String namen, String vornamen, int id, int gehalt,Date geburtstag) {
        this.namen = namen;
        this.vornamen = vornamen;
        this.id = id;
        this.gehalt = gehalt;
        this.gehaltsfaktor = 1;
        this.geburtstag = geburtstag;
    }

    public double getGehalt(){
        return gehalt*gehaltsfaktor;
    }

}
