package de.thws.AlgoDat2.a4;

import java.util.LinkedList;

public class AStar {

    int[][] graph; // G
    int[] est; // H

    LinkedList<Integer> open = new LinkedList<Integer>();
    LinkedList<Integer> closed = new LinkedList<Integer>();

    int[] f, vorgaenger;

    public AStar() {

        graph = new int[][] {

                //    A    B    C    D    E    F    G    H
                /* A */	{   0, 112,   0, 153,   0,   0,   0,   0},
                /* B */	{   0,   0,  62,   0,  98,   0,   0,   0},
                /* C */	{   0,   0,   0,   0,   0, 116,   0,   0},
                /* D */	{   0,   0,   0,   0,  63,   0,  51,   0},
                /* E */	{   0,   0,   0,   0,   0,  59,   0,   0},
                /* F */	{   0,   0,   0,   0,   0,   0,   0,  53},
                /* G */	{   0,   0,   0,   0,   0,   0,   0, 163},
                /* H */	{   0,   0,   0,   0,   0,   0,   0,   0}
        };

        // A    B    C    D    E   F    G  H
        est = new int[] {317, 211, 165, 161, 112, 57, 157, 0};

        f = new int[graph.length];
        vorgaenger = new int[graph.length];

        for(int i = 0; i < vorgaenger.length; i++)
            vorgaenger[i] = -1;
    }

    private void search(int start, int target) {

        open.add(start);

        for(int i = 0; i < graph.length; i++)
            f[i] = Integer.MAX_VALUE;

        f[start] = 0;

        while(open.size() > 0) {

			/*
			System.out.print("Open-List: ");
			for(int c = 0; c < open.size(); c++)
				System.out.print(tl(open.get(c)) + " (" + open.get(c) + ") | ");
			System.out.println();
			*/

            // get node with smallest F that is in open list
            int node = -1, node_f = Integer.MAX_VALUE;
            for(int i : open) {

                if(f[i] < node_f) {

                    node = i;
                    node_f = f[i];
                }
            }

            open.remove(Integer.valueOf(node));

            if(node == target) {

                return;
            }

            for(int i = 0; i < graph.length; i++) {

                if(i != node) {

                    if(graph[node][i] > 0) { // neighbor

                        int tmp = getPath(node, 0) + graph[node][i];
                        tmp += est[i];

                        if(tmp < f[i]) {

                            f[i] = tmp;
                            vorgaenger[i] = node;
                        }

                        if(!open.contains(i))
                            open.add(i);
                    }
                }
            }

            //closed.add(node);
        }
    }

    public int getPath(int node, int sum) {

        if(vorgaenger[node] >= 0) {

            sum += graph[vorgaenger[node]][node];
            return getPath(vorgaenger[node], sum);
        }

        return sum;
    }

    public void showTableAndPath(int start, int target) {

        for(int i = 0; i < graph.length; i++)
            System.out.println(tl(i) + " | " + f[i] + " | " + tl(vorgaenger[i]));

        System.out.println("-----------------------");

        String path = "" + tl(target);
        int current = target;
        while(current != start) {

            path = tl(vorgaenger[current]) + " -> " + path;
            current = vorgaenger[current];
        }
        System.out.println(path);
    }

    public char tl(int i) {

        if(i < 0) return '0';

        char[] letters = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        return letters[i];
    }

    public static void main(String[] args) {

        AStar a = new AStar();

        a.search(0, 7);
        a.showTableAndPath(0, 7);
    }
}
