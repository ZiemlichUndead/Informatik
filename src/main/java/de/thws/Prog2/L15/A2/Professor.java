package de.thws.Prog2.L15.A2;

public class Professor extends Person {

    public Professor(String fach) {
        super(fach);
    }

    @Override
    public void gibTaetigkeitAus() {
        System.out.println("Der Professor unterrichtet "+fach+".");
    }
}
