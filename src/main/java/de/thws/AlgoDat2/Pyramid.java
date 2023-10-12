package de.thws.AlgoDat2;

public class Pyramid {

    public static void main(String[] args) {

        int[][] pyramid = {
                {5},
                {3, 7},
                {6, 1, 2},
                {3, 8, 5, 4},
                {3, 4, 2, 6, 0}
        };

        int longestPath = findLongestPath(pyramid, 0, 0);
        System.out.println("Der längste Pfad von der Spitze bis zum Boden der Pyramide beträgt: " + longestPath);
    }


    public static int findLongestPath(int[][] pyramid, int row, int col) {
        if (row == pyramid.length - 1) {
            // Wir haben den Boden der Pyramide erreicht, daher ist der längste Pfad die aktuelle Zahl.
            return pyramid[row][col];
        } else {
            // Rekursiv den besten Pfad von den beiden möglichen Pfaden auswählen.
            int leftPath = findLongestPath(pyramid, row + 1, col);
            int rightPath = findLongestPath(pyramid, row + 1, col + 1);

            // Den längeren Pfad auswählen und zur aktuellen Zahl addieren.
            return pyramid[row][col] + Math.max(leftPath, rightPath);
        }
    }

}
