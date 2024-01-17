package de.thws.AlgoDat2.A11;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Heap <T> {



    Node<T>[] nodes;
    int size;



    public static void main(String[] args) {
        Heap<String> heap = new Heap<>();
        heap.insert(71,"Lol");
        heap.insert(57,"Lol");
        heap.insert(39,"Lol");
        heap.insert(63,"Lol");
        heap.insert(31,"Lol");
        heap.insert(42,"Lol");
        heap.insert(17,"Lol");
        heap.insert(23,"Lol");
        heap.insert(27,"Lol");
        System.out.println(Arrays.toString(heap.nodes));

        System.out.println(heap.extract());
        System.out.println(Arrays.toString(heap.nodes));

//        int i = 1;
//        int row = 1;
//        for (Node<String> node : heap.nodes) {
//
//            if()
//        }

    }


    public Heap() {
        nodes = new Node[100];
    }
    public void insert(int prio,T data){
        nodes[size] = new Node<>(prio, data);
        int x = size;
        size++;
        while (x >= 0 && nodes[x].prio < nodes[(x-1)/2].prio){
            swap(x, (x-1)/2);
            x = (x-1)/2;
        }
    }

    public T extract(){
        T data = nodes[0].data;
        nodes[0] = nodes[size-1];
        size--;
        adjust(0);
        return data;
    }


    public void swap(int n1, int n2){
        Node<T> temp = nodes[n1];
        nodes[n1] = nodes[n2];
        nodes[n2] = temp;
    }

    public void adjust(int x){
        int left = x * 2 + 1;
        int right = x * 2 + 2;
        int min = x;

        if (left < size && nodes[left].prio < nodes[min].prio){
            min = left;
        }
        if (right < size && nodes[right].prio < nodes[min].prio){
            if (right < min){
//            if (nodes[right].prio < nodes[min].prio){
                min = right;
            }
        }

       if (min != x){
           swap(x, min);
           adjust(min);
       }
    }



    public static class Node <T> {
        int prio = 0;
        T data;

        public Node(int prio, T data) {
            this.prio = prio;
            this.data = data;
        }

        @Override
        public String toString() {
            return ""+prio;
        }
    }

}
