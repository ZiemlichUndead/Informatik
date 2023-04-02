package de.thws.Prog2.L15.A3;

public class Quiz {

    Frage[] fragen = new Frage[10];
    int letzteFrage = 0;

    public Quiz() {
    }

    public void addFrage(Frage f){
        if(letzteFrage >= fragen.length){
            throw new RuntimeException("Too many questions");
        }
        fragen[letzteFrage++] = f;
    }

    @Override
    public String toString() {
        String output = "Quizbogen:\n";

        for (int i = 0; i < letzteFrage; i++) {
            output+=fragen[i].output();
        }
        return output;
    }

    public static void main(String[] args) {
        Quiz q = new Quiz();
        q.addFrage(new Frage.Textfrage("Was ist die Hauptstadt von Deutschland?"));
        q.addFrage(new Frage.MCFrage("Wie viele Protonen hat ein Wasserstoff-Atom?",new String[]{"4","2","1","0"}));
        System.out.println(q);
    }


}
