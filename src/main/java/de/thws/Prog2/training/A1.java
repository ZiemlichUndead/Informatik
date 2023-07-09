package de.thws.Prog2.training;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class A1 {

    public static class Fahrt{
        public int km;
        public int min;
    }

    public static abstract class Fahrzeug{


        public List<Fahrt> fahrtbuch = new ArrayList<>();
        public abstract float berechneEntgeld(Fahrt f);

        public void fahrtbuchEintrag(Fahrt f){
            fahrtbuch.add(f);
        }
    }

    public static class Fahrrad extends Fahrzeug{

        @Override
        public float berechneEntgeld(Fahrt f) {
            return 0.125f * (float) f.min;
        }
    }
    public static class Motorroller extends Fahrzeug{

        @Override
        public float berechneEntgeld(Fahrt f) {
            return 3f + 0.15f * (float) f.km;
        }
    }
    public static class Kleintransporter extends Fahrzeug{

        @Override
        public float berechneEntgeld(Fahrt f) {
            int min = f.min;

            float entgeld = 0.30f * f.km;
            if(min > 60){
                entgeld += 0.25f * (min-60);
            }

            return entgeld;
        }

    }

    public static interface Elektrofahrzeug{
        public void returnToCharger();
    }

    public static class ElektrofahrzeugImpl implements Elektrofahrzeug{

        @Override
        public void returnToCharger() {

        }
    }

    public static class Elektroroller extends Motorroller implements Elektrofahrzeug {

        Elektrofahrzeug ev = new ElektrofahrzeugImpl();

        @Override
        public void returnToCharger() {
            ev.returnToCharger();
        }

    }


    public static class Umsatzberechner{

        public List<Fahrzeug> fahrzeuge = new ArrayList<>();
        public float getGesamtUmsatz(boolean nurElektro){
            Stream<Fahrzeug> fahrzeugStream = fahrzeuge.stream();

            if(nurElektro) {
                fahrzeugStream = fahrzeugStream.filter(fahrzeug -> (fahrzeug instanceof Elektrofahrzeug));
            }

            return fahrzeugStream.flatMap(fahrzeug -> fahrzeug.fahrtbuch.stream().map(fahrzeug::berechneEntgeld)).reduce(Float::sum).get();
        }

        public float berechneUmsatz(){
            return getGesamtUmsatz(false);
        }
        public float berechneElektroUmsatz(){
            return getGesamtUmsatz(true);
        }
    }
}
