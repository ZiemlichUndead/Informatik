package de.thws.AlgoDat2.a4.own;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dijkstra {

    public static void main(String[] args) {
        List<Node> graph = new ArrayList<>();
        graph.add(new Node("A"));
        graph.add(new Node("B"));
        graph.add(new Node("C"));
        graph.add(new Node("D"));
        graph.add(new Node("E"));

        graph.get(0).distanceNodeMap.put(graph.get(1),10);
        graph.get(0).distanceNodeMap.put(graph.get(3),5);

        graph.get(1).distanceNodeMap.put(graph.get(0),10);
        graph.get(1).distanceNodeMap.put(graph.get(3),10);
        graph.get(1).distanceNodeMap.put(graph.get(4),25);
        graph.get(1).distanceNodeMap.put(graph.get(2),10);

        graph.get(2).distanceNodeMap.put(graph.get(2),10);
        graph.get(2).distanceNodeMap.put(graph.get(4),5);

        graph.get(3).distanceNodeMap.put(graph.get(0),5);
        graph.get(3).distanceNodeMap.put(graph.get(1),10);
        graph.get(3).distanceNodeMap.put(graph.get(4),25);

        graph.get(4).distanceNodeMap.put(graph.get(1),25);
        graph.get(4).distanceNodeMap.put(graph.get(2),5);
        graph.get(4).distanceNodeMap.put(graph.get(3),25);

        Node[] path = dijkstra(graph,0);

        for (Node node : path) {
            System.out.println(node.name);
        }

    }

    public static class Node{
        String name;
        HashMap<Node,Integer> distanceNodeMap = new HashMap<>();

        public Node(String name) {
            this.name = name;
        }
    }

    static Node[] dijkstra(List<Node> graph, int start) {
        List<Node> list = graph;

        Node[] previous = new Node[list.size()];

        int[] cost = new int[list.size()];
        for (int i = 0; i < cost.length; i++) {
            cost[i] = 1000;
        }
        cost[start] = 0;


        while(list.size() > 1){
            int current = smallestOfList(cost);
            list.remove(current);

            for (Node neigbour : list.get(current).distanceNodeMap.keySet()) {
                if(list.contains(neigbour)){
                    int alt = cost[current]+list.get(current).distanceNodeMap.get(neigbour);

                    if(alt<cost[list.indexOf(neigbour)] && cost[list.indexOf(neigbour)] != -1){
                        cost[list.indexOf(neigbour)] = alt;
                        previous[list.indexOf(neigbour)] = list.get(current);
                    }
                }
            }

        }

        return previous;
    }

    static int smallestOfList(int[] list){
        int smallest = list[0];
        for (int i = 1; i < list.length; i++) {
            if(smallest > list[i] && list[i] != -1){
                smallest = list[i];
            }
        }
        return smallest;
    }

}
