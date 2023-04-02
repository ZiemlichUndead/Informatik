package de.thws.Prog2.L15.A3;

public abstract class Frage {

    String fragetext;
    String frageOutput;

    public Frage(String fragetext) {
        this.fragetext = fragetext;
    }

    protected abstract void generateFrageOutput();
    public String output(){
        return frageOutput;
    }



    public static class Textfrage extends Frage{

        public Textfrage(String fragetext) {
            super(fragetext);
            generateFrageOutput();
        }

        protected void generateFrageOutput(){
            frageOutput = fragetext+"\n\n\n";
        }

    }
    public static class MCFrage extends Frage{

        String[] antworten;
        public MCFrage(String fragetext,String[] antworten) {
            super(fragetext);
            this.antworten = antworten;
            generateFrageOutput();
        }

        protected void generateFrageOutput() {
            this.frageOutput = fragetext+"\n\nAntwortmöglichkeiten:\n";

            if(antworten.length > 16){
                throw new RuntimeException("Not enough letters in alphabet to display answers");
            }

            for (int i = 0; i < antworten.length; i++) {

                this.frageOutput += new String(new char[] {(char) ('A'+i)}) +": "+antworten[i]+"\n";
            }
        }
    }
}
