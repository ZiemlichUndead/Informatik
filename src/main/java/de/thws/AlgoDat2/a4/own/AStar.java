package de.thws.AlgoDat2.a4.own;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AStar {

    private static class Node{
        String name;
        int H;
        HashMap<Node,Integer> neigbourDistances = new HashMap<>();

        public Node(String name, int h) {
            this.name = name;
            H = h;
        }
    }

    public static void main(String[] args) {
        Node[] graph = new Node[8];
        graph[0] = new Node("A",317);
        graph[1] = new Node("B",211);
        graph[2] = new Node("C",165);
        graph[3] = new Node("D",161);
        graph[4] = new Node("E",112);
        graph[5] = new Node("F",57);
        graph[6] = new Node("G",157);
        graph[7] = new Node("H",0);

        graph[0].neigbourDistances.put(graph[1],112);
        graph[0].neigbourDistances.put(graph[3],153);

        graph[1].neigbourDistances.put(graph[0],112);
        graph[1].neigbourDistances.put(graph[2],62);
        graph[1].neigbourDistances.put(graph[4],98);

        graph[2].neigbourDistances.put(graph[1],62);
        graph[2].neigbourDistances.put(graph[5],116);

        graph[3].neigbourDistances.put(graph[0],153);
        graph[3].neigbourDistances.put(graph[4],63);
        graph[3].neigbourDistances.put(graph[6],51);

        graph[4].neigbourDistances.put(graph[3],63);
        graph[4].neigbourDistances.put(graph[1],98);
        graph[4].neigbourDistances.put(graph[5],59);

        graph[5].neigbourDistances.put(graph[4],59);
        graph[5].neigbourDistances.put(graph[2],116);
        graph[5].neigbourDistances.put(graph[7],53);

        graph[6].neigbourDistances.put(graph[3],51);
        graph[6].neigbourDistances.put(graph[7],163);

        graph[7].neigbourDistances.put(graph[6],163);
        graph[7].neigbourDistances.put(graph[5],53);

    }


    static void astar(Node[] graph,int start, int target){
        List<Node> open = new ArrayList<>();
        open.add(graph[start]);
        
        while(!open.isEmpty()){
            Node node = getSmallestF(open);
            
        }
        
    }
    
    static Node getSmallestF(List<Node> list){
        for (Node node : list) {
            
        }
        return null;
    }

}
