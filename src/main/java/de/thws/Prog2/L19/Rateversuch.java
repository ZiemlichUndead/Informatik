package de.thws.Prog2.L19;


import java.io.Serializable;

public class Rateversuch implements Serializable {
    String blankedWort;
    boolean geschafft;
    boolean treffer;

    public Rateversuch(String blankedWort, boolean geschafft, boolean treffer) {
        this.blankedWort = blankedWort;
        this.geschafft = geschafft;
        this.treffer = treffer;
    }
}
