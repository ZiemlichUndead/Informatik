package de.thws.Prog2.L24.A2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Karte
{
    Farbe farbe;
    Wert wert;
    public Karte(Farbe farbe, Wert wert)
    {
        this.farbe = farbe;
        this.wert = wert;
    }
    @Override
    public String toString()
    {
        return farbe + " " + wert;
    }

    public static class Kartendeck
    {
        List<Karte> karten;

        public void erzeugeDeck(){
//            karten = new ArrayList<>();
//            Arrays.stream(Farbe.values()).forEach(farbe -> Arrays.stream(Wert.values()).forEach(wert -> karten.add(new Karte(farbe,wert))));
//            Arrays.stream(Farbe.values()).collect(ArrayList::new,(list, farbe) ->list.add(farbe),(l1,l2) -> l1.addAll(l2));
//            karten.stream().forEach(System.out::println);

            karten = Arrays.stream(Farbe.values()).flatMap(farbe -> Arrays.stream(Wert.values()).map(wert -> new Karte(farbe,wert))).toList();
//            karten.stream().forEach(System.out::println);

        }

        @Override
        public String toString() {
            return karten.stream().map(karte -> karte.toString()+ ", ").reduce((karte1,karte2) -> karte1+karte2).get();
        }
    }
    public enum Farbe
    {
        KREUZ, PIK, HERZ, KARO
    }
    public enum Wert
    {
        BUBE, ASS, ZEHN, KOENIG, DAME, NEUN, ACHT,
        SIEBEN
    }

    public static void main(String[] args) {
        Kartendeck kd = new Kartendeck();
        kd.erzeugeDeck();
        System.out.println(kd);
        kd.karten.forEach((ThrowingConsumer.unchecked(System.out::println)));
    }


    @FunctionalInterface
    public interface ThrowingFunction<T, R, E extends Exception>
    {
        R apply(T t) throws E;
        static <T, R, E extends Exception> Function<T, R> unchecked(ThrowingFunction<T, R, E> function)
        {
            return t -> {
                try
                {
                    return function.apply(t);
                }
                catch (Exception e)
                {
                    throw new RuntimeException(e);
                }
            };
        }
    }

    public interface ThrowingConsumer<T, E extends Exception>
    {
        void apply(T t) throws E;

        static <T, E extends Exception> Consumer<T> unchecked(ThrowingConsumer<T, E> function)
        {
            return t -> {
                try
                {
                    function.apply(t);
                }
                catch (Exception e)
                {
                    throw new RuntimeException(e);
                }
            };
        }
    }
}