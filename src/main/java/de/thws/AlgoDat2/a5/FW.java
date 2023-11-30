package de.thws.AlgoDat2.a5;

import java.util.Arrays;

public class FW {



    private static int[][] graph = new int[][] {

            //         A   B   C   D   E  F   G
            /* A */	{  0,  5,  0,  3,  0,  0, 0},
            /* B */	{  0,  0,  1,  0,  1, -1, 0},
            /* C */	{  0,  0,  0,  0,  0, -3, 0},
            /* D */	{  0,  0,  0,  0,  2,  0, 3},
            /* E */	{  0,  0,  0,  0,  0, -1, 1},
            /* F */	{  0,  0,  0,  0,  0,  0, 2},
            /* G */	{  0,  0,  0,  0,  0, 0,  0}
    };

    public static void main(String[] args) {
        bellford(graph, 3);

        for (int i : vorgaenger) {
            System.out.println("Vorgänger: "+i);
        }
        for (int i : kosten) {
            System.out.println("Kosten: "+i);
        }
    }

    private static int[] kosten = new int[graph.length];
    private static int[] vorgaenger = new int[graph.length];

    public static void bellford(int[][] graph, int start){
        Arrays.fill(kosten, Integer.MAX_VALUE);
        kosten[start] = 0;

        for (int i = 1; i < graph.length - 1; i++) {

            for (int u = 0; u < graph[i].length; u++) {
                for (int v = 0; v < graph[u].length; v++) {

                    if (kosten[u] < Integer.MAX_VALUE && (/*u==v ||*/ graph[u][v] != 0)) {
                        if (kosten[u] + graph[u][v] < kosten[v]) {
                            kosten[v] = kosten[u] + graph[u][v];
                            vorgaenger[v] = u;
                        }
                    }
                }
            }
        }
    }

}
