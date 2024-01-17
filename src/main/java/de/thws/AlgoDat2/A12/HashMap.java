package de.thws.AlgoDat2.A12;

import java.util.Arrays;

public class HashMap {

    String[] arr = new String[128];

    public HashMap(){
        Arrays.fill(arr, "");
    }
    void add(String s){
        arr[h1(s)] = s;
        System.out.println(this);
    }
    void addBetter(String s){
        int i = h1(s);
        while (!arr[i].equals("")){
            int b1 = Math.abs((i - h2(s)) % arr.length);
            int b2 = Math.abs((i - h2(arr[i])) % arr.length);
            if(!arr[b1].equals("") && arr[b2].equals("")){
                String temp = s;
                s = arr[i];
                arr[i] = temp;
                i = b2;
            }
            else{
                i = b1;
            }
        }
        arr[i] = s;

        System.out.println(this);
    }

    boolean search(String s){
//        int pos = h1(s);
        int pos = h1(s) + h2(s);
        return !arr[pos].isEmpty();
    }

    int h1(String s){
        int h = 0;
        for(char c : s.toCharArray()){
            h = h + c;
        }
        return h % arr.length;
    }
    int h2(String s){
//        int h = 0;
//        for(char c : s.toCharArray()){
//            h = h + c;
//        }
        return s.hashCode() % arr.length;
//        return h%arr.length;
    }

    @Override
    public String toString() {
        return "HashMap{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.addBetter("Test123");
        hashMap.addBetter("Test1234");
        hashMap.addBetter("Test12345");
        hashMap.addBetter("1Test2345");
        hashMap.addBetter("12Test345");


//        System.out.println(hashMap.search("Test123"));
    }

}
