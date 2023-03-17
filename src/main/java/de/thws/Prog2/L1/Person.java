package de.thws.Prog2.L1;

public class Person {
    public String vorname,nachname;
    public Adresse adresse;

    public Person(String vorname,String nachname,String strasse, String hausnummer, String postleitzahl, String ort){

        if(Character.isLowerCase(vorname.charAt(0)) ||
                Character.isLowerCase(nachname.charAt(0)) ||
                Character.isLowerCase(strasse.charAt(0)) ||
                Character.isLetter(hausnummer.charAt(0))){
            throw new RuntimeException("One of the fields has an unlegitimate value");
        }

        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = new Adresse(strasse, hausnummer, postleitzahl, ort);
    }
    public static class Adresse{
       public String strasse,hausnummer,postleitzahl, ort;

        public Adresse(String strasse, String hausnummer, String postleitzahl, String ort) {
            this.strasse = strasse;
            this.hausnummer = hausnummer;
            this.postleitzahl = postleitzahl;
            this.ort = ort;
        }
    }
}
