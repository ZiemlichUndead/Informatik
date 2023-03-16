package Training;


    public class Knoten {
        String nachname;
        String vorname;
        String telefonnummer;
        Knoten right = null;
        Knoten left = null;


        public Knoten(String nachname) {
            this.nachname = nachname;
        }


    }

