package de.thws.AlgoDat2.a5;

import java.util.Arrays;

public class BF {
//    private static int[][] graph = new int[][] {
//
//            //         A   B   C   D   E   F
//            /* A */	{  0,  5,  0,  3,  3,  0},
//            /* B */	{  4,  0,  2,  0,  3,  3},
//            /* C */	{  0,  3,  0,  0,  3,  3},
//            /* D */	{  1,  0,  0,  0,  2,  0},
//            /* E */	{  0,  -1, 0, -1,  0, -1},
//            /* F */	{  0,  0,  4,  0,  3,  0}
//    };

    private static int[][] graph = new int[][] {

            //          A  B  C  D  E  F  G  H
            /* A */	{   0, 3, 1, 0, 3, 8, 2, 0},
            /* B */	{   4, 0, 0, 0, 2, 0, 7, 3},
            /* C */	{   3, 7, 0, 0, 8, 3, 0, 3},
            /* D */	{   6, 0, 0, 0, 3, 0, 4, 9},
            /* E */	{   0, 0, 5, 5, 0, 0, 1, 6},
            /* F */	{   2, 2, 8, 0, 0, 0, 0, 5},
            /* G */	{   0, 0, 0, 0, 0, 0, 0, 8},
            /* G */	{   0, 0, 0, 0, 3, 0, 8, 0}
    };

    public static void main(String[] args) {

        for(int a = 0; a < graph.length; a++) {
            for(int b = 0; b < graph.length; b++) {

                path[a][b] = -1;
            }
        }

        int[][] out = bellford(graph, graph.length);
        /*for (int i = 0; i < out.length; i++) {
            for (int j = 0; j < out.length; j++) {
                System.out.print(out[i][j]+", ");
            }
            System.out.println();
        }*/

        Arrays.stream(out).forEach(row -> {
            Arrays.stream(row).forEach(element -> {
                System.out.print(element);
                System.out.print("\t");
            });
            System.out.println();
        });

        System.out.println("Path:");
        Arrays.stream(path).forEach(row -> {
            Arrays.stream(row).forEach(element -> {
                System.out.print(element);
                System.out.print("\t");
            });
            System.out.println();
        });
    }

    private static int[][] dist = new int[graph.length][graph.length];
    private static int[][] path = new int[graph.length][graph.length];

    public static int[][] bellford(int[][] graph, int n){

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i!=j) {
                    if (graph[i][j] != 0) {
                        dist[i][j] = graph[i][j];
                    } else {
                        dist[i][j] = Integer.MAX_VALUE;
                    }
                }
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(i!=j && dist[i][k] < Integer.MAX_VALUE && dist[k][j] < Integer.MAX_VALUE){
//                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                        if ((dist[i][k] + dist[k][j]) < dist[i][j]) {
                            dist[i][j] = (dist[i][k] + dist[k][j]);
//                        path[i][j] = path[k][j];
                            path[i][j] = k;
                        }
                    }
                }
            }
        }

        return dist;
    }

}
