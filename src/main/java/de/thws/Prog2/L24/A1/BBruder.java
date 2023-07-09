package de.thws.Prog2.L24.A1;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class BBruder
{
    String name;
    int bankDrueckenGewicht;
    int knieBeugenGewicht;
    public BBruder(String name, int bankDrueckenGewicht, int
            knieBeugenGewicht)
    {
        this.name = name;
        this.bankDrueckenGewicht = bankDrueckenGewicht;
        this.knieBeugenGewicht = knieBeugenGewicht;
    }
    @Override
    public String toString()
    {
        return String.format(
                "Name: %s, Bankdrücken: %dkg, Kniebeugen %dkg",
                name, bankDrueckenGewicht, knieBeugenGewicht);
    }
    public static void main(String[] args)
    {
        List<BBruder> bBrothers = List.of(new BBruder("Burt", 238, 311),
                new BBruder("Bronski", 200, 274),
                new BBruder("Bruno", 236, 328));


        bBrothers.stream().map(bBruder -> bBruder.name).reduce((b1,b2) -> b1+ ", "+b2
        ).stream().forEach(System.out::println);

        bBrothers.stream().map(bBruder -> bBruder.bankDrueckenGewicht).reduce((b1,b2) -> (b1+b2)).stream().forEach(sum -> System.out.println((double) sum/(double)bBrothers.size()));

        System.out.println(bBrothers.stream().map(bBruder -> bBruder.name).collect(Collectors.joining(", ")));
        bBrothers.stream().mapToDouble(bBruder -> bBruder.bankDrueckenGewicht).average().ifPresent(System.out::println);
    }
}