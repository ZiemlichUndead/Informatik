package de.thws.Prog2.L15.A2;

public abstract class Person {
    String fach;

    public Person(String fach) {
        this.fach = fach;
    }

    public abstract void gibTaetigkeitAus();

    public static void main(String[] args) {
        Person[] personen = new Person[100];

        for (int i = 0; i < personen.length; i++) {
            if(i%2 ==0){
                personen[i] = new Student("Programmieren");
            }else{

                personen[i] = new Professor("Programmieren");
            }
        }

        for (Person person : personen) {
            person.gibTaetigkeitAus();
        }
    }

}
