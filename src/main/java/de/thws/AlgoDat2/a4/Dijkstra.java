package de.thws.AlgoDat2.a4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class Dijkstra {

    private int[][] graph = null;
    private int[] kosten, vorgaenger;

    LinkedList<Integer> lst = new LinkedList<Integer>();

    public Dijkstra() {}

    public void loadDefault() {

        graph = new int[][] {

                //   A   B   C   D   E  F
                /* A */	{  0, 10,  0,  5,  0,  0},
                /* B */	{ 10,  0, 10, 10, 25,  0},
                /* C */	{  0, 10,  0,  0,  5, 15},
                /* D */	{  5, 10,  0,  0, 25,  0},
                /* E */	{  0, 25,  5, 25,  0,  5},
                /* F */	{  0,  0, 15,  0,  5,  0}
        };

        kosten = new int[graph.length];
        vorgaenger = new int[graph.length];
    }

    public void search(int startNode) {

        for(int i = 0; i < graph.length; i++)
            lst.add(i);

        for(int i = 0; i < kosten.length; i++)
            kosten[i] = Integer.MAX_VALUE;

        kosten[startNode] = 0;

        while(lst.size() > 0) {

            // smallestOfList (in list and smallest costs)
            int u = -1, u_kosten = Integer.MAX_VALUE;
            for(int i = 0; i < kosten.length; i++) {

                if(kosten[i] < u_kosten && lst.contains(i)) {
                    u = i;
                    u_kosten = kosten[i];
                }
            }

            if(u >= 0) {
                // remove u from list
                lst.remove(Integer.valueOf(u));

                // check neighbors of u
                for(int v = 0; v < graph.length; v++) {

                    if(graph[u][v] > 0 && u != v) { // a neighbor is from u to v

                        if(lst.contains(v)) {

                            int alt = kosten[u] + graph[u][v]; // alt costs to v via u
                            if(alt < kosten[v]) {

                                kosten[v] = alt;
                                vorgaenger[v] = u;
                            }
                        }
                    }
                }
            }
        }

        for(int i = 0; i < vorgaenger.length; i++) {
            System.out.println(tl(i) + " -> " + tl(vorgaenger[i]));
        }
    }

    public void printPath(int startNode, int targetNode) {

        String result = "" + tl(targetNode);

        int current = targetNode;

        while(current != startNode) {

            result = tl(vorgaenger[current]) + " -> " + result;
            current = vorgaenger[current];
        }
        System.out.println(result);
    }

    public String tl(int i) {

        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return letters.charAt(i) + " (" + i + ")";
    }

    public void loadGraph(String fname) {

        try {

            BufferedReader br = new BufferedReader(new FileReader(fname));
            String line = br.readLine();

            int line_count = 0;

            while(line != null) {

                String[] tokens = line.split(",");

                if(graph == null)
                    graph = new int[tokens.length][tokens.length];

                for(int i = 0; i < tokens.length; i++)
                    graph[line_count][i] = Integer.parseInt(tokens[i]);

                line_count++;
                line = br.readLine();
            }

        } catch(Exception e) { e.printStackTrace(); }

		/*
		for(int i = 0; i < graph.length; i++) {
			for(int j = 0; j < graph.length; j++) {

				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
		*/

        kosten = new int[graph.length];
        vorgaenger = new int[graph.length];
    }

    public static void main(String[] args) {

        Dijkstra d = new Dijkstra();

        //d.loadDefault();
        //d.search(0);
        //d.printPath(0, 5);

        d.loadGraph("Ueb04\\graph.txt");
        d.search(0);
        d.printPath(0, 25);
    }
}
