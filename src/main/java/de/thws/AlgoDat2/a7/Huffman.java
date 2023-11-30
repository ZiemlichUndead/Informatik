package de.thws.AlgoDat2.a7;

import java.util.*;
import java.util.stream.Collectors;

public class Huffman {

    //function to build Huffman tree
    public static void createHuffmanTree(String text)
    {
        if (text == null || text.length() == 0)
        {
            return;
        }

        Map<Character, Integer> freq = new HashMap<>();
        for (char c: text.toCharArray())
        {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(l -> l.freq));

        for (var entry: freq.entrySet())
        {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }
        while (pq.size() != 1)
        {
            Node left = pq.poll();
            Node right = pq.poll();
            int sum = left.freq + right.freq;
            pq.add(new Node(null, sum, left, right));
        }

        Node root = pq.peek();
        Map<Character, String> huffmanCode = new HashMap<>();
        encodeData(root, "", huffmanCode);
        System.out.println("Huffman Codes of the characters are: " + huffmanCode);
        System.out.println("The initial string is: " + text);
        StringBuilder sb = new StringBuilder();
        for (char c: text.toCharArray())
        {
            sb.append(huffmanCode.get(c));
        }
        System.out.println("The encoded string is: " + sb);
        System.out.print("The decoded string is: ");
        if (isLeaf(root))
        {
            while (root.freq-- > 0)
            {
                System.out.print(root.ch);
            }
        }
        else
        {
            int index = -1;
            while (index < sb.length() - 1)
            {
                index = decodeData(root, index, sb);
            }
        }
    }
    public static void encodeData(Node root, String str, Map<Character, String> huffmanCode)
    {
        if (root == null)
        {
            return;
        }
        if (isLeaf(root))
        {
            huffmanCode.put(root.ch, str.length() > 0 ? str : "1");
        }
        encodeData(root.left, str + '0', huffmanCode);
        encodeData(root.right, str + '1', huffmanCode);
    }
    public static int decodeData(Node root, int index, StringBuilder sb)
    {
        if (root == null)
        {
            return index;
        }
        if (isLeaf(root))
        {
            System.out.print(root.ch);
            return index;
        }
        index++;
        root = (sb.charAt(index) == '0') ? root.left : root.right;
        index = decodeData(root, index, sb);
        return index;
    }
    public static boolean isLeaf(Node root)
    {
        return root.left == null && root.right == null;
    }
    public static void main(String args[])
    {
        String text = "javatpoint";
        //function calling
        createHuffmanTree(text);
    }

//    public static String encrypt(String input){
//
//        HashMap<Character,Integer> map = new HashMap<>();
//        for (char c : input.toCharArray()) {
//            if(map.containsKey(c)){
//                map.put(c,map.get(c)+1);
//            }else{
//                map.put(c,1);
//            }
//        }
//
//        System.out.println(map);
//        HashMap<Character, List<Integer>> sequence = new HashMap<>();
//
//        Character first = null;
//
//        int current = 1;
//        int charNumber = 0;
//
//        while (current < 30){
//            if(map.containsValue(current)){
//                Character n = null;
//                for (Character c : map.keySet()) {
//                    if(map.get(c) == current){
//                        n = c;
//                        break;
//                    }
//                }
//                System.out.println("Char: "+n);
//                map.remove(n);
//                charNumber++;
//
//                if(first == null){
//                    System.out.println("Adding as 1");
//                    first = n;
//                    sequence.putIfAbsent(n,new ArrayList<>());
//                    sequence.get(n).add(1);
//                }else {
//                    System.out.println("Adding as 0");
//                    first = null;
//                    sequence.putIfAbsent(n,new ArrayList<>());
//                    sequence.get(n).add(0);
//                }
//
//            }else{
//
//                current++;
//                System.out.println("New current: "+current);
//                first = null;
//            }
//        }
//
//        System.out.println(sequence);
//        return null;
//    }


    //defining a class that creates nodes of the tree
    static class Node
    {
        //storing character in ch variable of type character
        Character ch;
        //storing frequency in freq variable of type int
        Integer freq;
        //initially both child (left and right) are null
        Node left = null;
        Node right = null;
        //creating a constructor of the Node class
        Node(Character ch, Integer freq)
        {
            this.ch = ch;
            this.freq = freq;
        }
        //creating a constructor of the Node class
        public Node(Character ch, Integer freq, Node left, Node right)
        {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }
    }

}
