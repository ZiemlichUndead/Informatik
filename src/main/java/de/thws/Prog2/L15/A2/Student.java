package de.thws.Prog2.L15.A2;

public class Student extends Person{

    public Student(String fach) {
        super(fach);
    }

    @Override
    public void gibTaetigkeitAus() {
        System.out.println("Der Student besucht das Fach "+fach+".");
    }
}
