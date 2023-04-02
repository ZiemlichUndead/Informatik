package de.thws.Prog2.L15.A1;

public class Abteilung {
    public Angestellter[] angestellte;
    public Abteilungsleiter abteilungsleiter;

    public Abteilung(Abteilungsleiter abteilungsleiter, Angestellter[] angestellte) {
        this.abteilungsleiter = abteilungsleiter;
        this.angestellte = angestellte;
    }
}
