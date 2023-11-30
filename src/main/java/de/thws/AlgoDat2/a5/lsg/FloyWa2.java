package de.thws.AlgoDat2.a5.lsg;

public class FloyWa2 {


    int[][] graph, dist, vorgaenger;

    public FloyWa2() {

        graph = new int[][] {

                //        A  B  C  D  E  F  G  H
                /* A */	{ 0, 3, 1, 0, 3, 8, 2, 0},
                /* B */	{ 4, 0, 0, 0, 2, 0, 7, 3},
                /* C */	{ 3, 7, 0, 0, 8, 3, 0, 3},
                /* D */	{ 6, 0, 0, 0, 3, 0, 4, 9},
                /* E */	{ 0, 0, 5, 5, 0, 0, 1, 6},
                /* F */	{ 2, 2, 8, 0, 0, 0, 0, 5},
                /* G */	{ 0, 0, 0, 0, 0, 0, 0, 8},
                /* H */	{ 0, 0, 0, 0, 3, 0, 8, 0}
        };

        dist = new int[graph.length][graph.length];

        //vorgaenger = new int[graph.length][graph.length];

        vorgaenger = new int[][] {

                //        A   B   C   D   E  F   G    H
                /* A */	{ -1,  0,  1, -1,  0, 0,  0,  -1},
                /* B */	{  1, -1, -1, -1,  1, -1,  1,  1},
                /* C */	{  2,  2, -1, -1,  2,  2, -1,  2},
                /* D */	{  3, -1, -1, -1,  3, -1,  3,  3},
                /* E */	{ -1, -1,  4,  4, -1, -1,  1,  4},
                /* F */	{  5,  5,  5, -1, -1, -1, -1,  5},
                /* G */	{ -1, -1, -1, -1, -1, -1, -1,  6},
                /* H */	{ -1, -1, -1, -1,  7, -1,  7, -1}
        };

			/*
		for(int a = 0; a < graph.length; a++) {
			for(int b = 0; b < graph.length; b++) {

				vorgaenger[a][b] = -1;
			}
		}
		*/
    }

    private void search() {

        for(int a = 0; a < graph.length; a++) {
            for(int b = 0; b < graph.length; b++) {

                if(a != b) {

                    if(graph[a][b] != 0)
                        dist[a][b] = graph[a][b];

                    else
                        dist[a][b] = Integer.MAX_VALUE;
                }
            }
        }

        for(int k = 0; k < graph.length; k++) {
            for(int i = 0; i < graph.length; i++) {
                for(int j = 0; j < graph.length; j++) {

                    if(i != j) {

                        if(dist[k][j] < Integer.MAX_VALUE && dist[i][k] < Integer.MAX_VALUE) {

                            if((dist[i][k] + dist[k][j]) < dist[i][j]) {

                                dist[i][j] = (dist[i][k] + dist[k][j]);

                                //vorgaenger[i][j] = k;
                                vorgaenger[i][j] = vorgaenger[k][j]; // (!)
                            }
                        }
                    }
                }
            }
        }
    }

    public void printDist() {

        for(int a = 0; a < dist.length; a++)
            System.out.print(tl(a) + "\t| ");
        System.out.println();

        for(int a = 0; a < dist.length; a++) {

            System.out.print(tl(a) + " | ");

            for(int b = 0; b < dist.length; b++) {
                System.out.print(dist[a][b] + "\t| ");
            }
            System.out.println("");
        }
        System.out.println("----------------------------");
    }

    public void printVorgaenger() {

        for(int a = 0; a < dist.length; a++)
            System.out.print(tl(a) + "\t| ");
        System.out.println();

        for(int a = 0; a < vorgaenger.length; a++) {

            System.out.print(tl(a) + " | ");

            for(int b = 0; b < vorgaenger.length; b++) {

                if(vorgaenger[a][b] > 0)
                    System.out.print(tl(vorgaenger[a][b]) + "\t| ");
                else
                    System.out.print("0\t| ");
            }
            System.out.println("");
        }
    }

    public char tl(int i) {

        char[] letters = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        return letters[i];
    }

    public static void main(String[] args) {

        FloyWa2 fw = new FloyWa2();

        fw.search();
        fw.printDist();
        fw.printVorgaenger();
    }

}
