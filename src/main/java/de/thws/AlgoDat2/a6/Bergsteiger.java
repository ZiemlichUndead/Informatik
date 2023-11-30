package de.thws.AlgoDat2.a6;

import java.util.Random;
import java.util.Vector;

public class Bergsteiger {


    public static int maxRounds = 100;
    private static int[][] graph = new int[][] {

            //         A   B   C   D   E
            /* A */	{  0,  1,  0,  0,  3},
            /* B */	{  0,  0,  0,  1,  0},
            /* C */	{  0,  1,  0,  0,  0},
            /* D */	{  0,  0,  0,  1,  0},
            /* E */	{  2,  1,  0, -0,  0},
    };

    public static void main(String[] args) {
        Vector<Integer> start = new Vector<>(2);
        start.add(4);
        start.add(0);
        Vector<Integer> end = new Vector<>(2);
        end.add(0);
        end.add(4);

        climb(start,end);
    }

    static void climb(Vector<Integer> start, Vector<Integer> end){
        Vector<Integer> current = start;
        for (int i = 0; i < maxRounds; i++) {
            System.out.println("Climbing to: "+current);
            Vector<Integer> temp = current;
            for (int j = 0; j < 4; j++) {
                Vector<Integer> neigbour = getNeigbour(temp,j);
                if(graph.length <= neigbour.get(0) || graph[0].length <= neigbour.get(1) || 0 > neigbour.get(0) || 0 > neigbour.get(1)  || graph[neigbour.get(0)][neigbour.get(1)] == 1 ){
                    continue;
                }
                if(distance(neigbour,end) < distance(current,end)){
                    current = neigbour;
                }

            }
        }

    }

    public static double distance(Vector<Integer> current, Vector<Integer> target){
        return Math.sqrt(Math.pow(target.get(0)-current.get(0),2) + Math.pow(target.get(1)-current.get(1),2));
    }

    static  Vector<Integer> getNeigbour(Vector<Integer> current, int n){
        Vector<Integer> ret = new Vector<>(2);
        switch (n){
            case 0:
                ret.add(current.get(0)+1);
                ret.add(current.get(1));
                break;
            case 1:
                ret.add(current.get(0)-1);
                ret.add(current.get(1));
                break;
            case 2:
                ret.add(current.get(0));
                ret.add(current.get(1)+1);
                break;
            case 3:
                ret.add(current.get(0));
                ret.add(current.get(1)-1);
                break;

        }

        return ret;
    }

}
