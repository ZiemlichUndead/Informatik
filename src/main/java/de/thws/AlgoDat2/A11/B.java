package de.thws.AlgoDat2.A11;

public class B {


    public static Node methode(int[] array){
        return new Node(1);
    }




    public static class Node{
        int value = 0;
        Node[] children = new Node[100];

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return ""+value;
        }
    }

}
