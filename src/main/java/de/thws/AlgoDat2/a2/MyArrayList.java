package de.thws.AlgoDat2.a2;

import java.io.*;

public class MyArrayList <T> {


    T[] pointer;
    int size;
    int capacity;


    public T get(int i){
        return pointer[i];
    }

    public int size(){
        return size;
    }

    public void add(T y){

        if(capacity == 0){
            capacity = 1;
            pointer = (T[]) new Object[capacity];
        }

        if(size == capacity){
            capacity *=2;
            T[] newArray = (T[]) new Object[capacity];
            for (int i = 0; i < size; i++) {
                newArray[i] = pointer[i];
            }
            pointer = newArray;
        }
        size ++;
        pointer[size-1] = y;
    }

    public T getLast(){
        size--;
        return pointer[size];
    }

    public int search(T y){
        for (int i = 0; i < size; i++) {
            if(y == pointer[i]){
                return i;
            }
        }
        return -1;
    }

    public int searchCandle(double head, double body, double tail){
        for (int i = 0; i < size; i++) {
            Candle found = (Candle) pointer[i];
            if(found.head() == head || found.body() == body || found.tail() == tail){
                return i;
            }
        }
        return -1;
    }

    public void loadFile(String fname) throws IOException {
        BufferedReader s = new BufferedReader(new FileReader(fname));
        String line;
        while((line = s.readLine()) != null){
            if(line.startsWith("Time")){
                continue;
            }
            String ts = line.substring(0,line.indexOf("\t"));
            line = line.substring(line.indexOf("\t")+1);
            double open = Double.parseDouble(line.substring(0,line.indexOf("\t")));
            line = line.substring(line.indexOf("\t")+1);
            double high = Double.parseDouble(line.substring(0,line.indexOf("\t")));
            line = line.substring(line.indexOf("\t")+1);
            double low = Double.parseDouble(line.substring(0,line.indexOf("\t")));
            line = line.substring(line.indexOf("\t")+1);
            double close = Double.parseDouble(line.substring(0,line.indexOf("\t")));
            line = line.substring(line.indexOf("\t")+1);
            int volume = Integer.parseInt(line);
            add((T) new Candle(ts,open,high,low,close,volume));
        }
    }



    public static void main(String[] args) throws IOException {
        MyArrayList<Integer> l = new MyArrayList<>();
        l.add(0);
        l.add(3);
        l.add(6);
        l.add(8);
        l.add(9);

        System.out.println(l.get(2));
        System.out.println(l.getLast());
        System.out.println(l.search(3));
        System.out.println(l.search(9));

        MyArrayList<Candle> l1 = new MyArrayList<>();
        l1.add(new Candle("",0,0,0,0,0));

        MyArrayList<Candle> l2 = new MyArrayList<>();

        l2.loadFile("EURUSD_H1.csv");
        for (int i = 0; i < l2.size(); i++) {
            System.out.println(l2.get(i));
        }

        int steigt = 0;
        int faellt = 0;
        for (int i = 0; i < l2.size(); i++) {
            Candle c = l2.get(i);
            Candle cnext = l2.get(i+1);
            if(c.tail() > c.body() && c.body() < 2 && c.head() == 0){
                System.out.println("Dragonfly");

                if(c.close < cnext.close){
                    System.out.println("Steigend");
                    steigt++;
                }else{
                    System.out.println("Fallend");
                    faellt++;
                }
            }

        }

        System.out.println("Steigt: "+steigt);
        System.out.println("Fällt: "+faellt);


    }



    public static class Candle{
        String timestamp;
        double open;
        double low;
        double high;
        double close;
        int volume;

        public Candle(String timestamp, double open, double low, double high, double close, int volume) {
            this.timestamp = timestamp;
            this.open = open;
            this.low = low;
            this.high = high;
            this.close = close;
            this.volume = volume;
        }

        public int head(){
            if(open> close){
                return (int) ((open-close) * 10000);
            }else{
                return 0;
            }
        }
        public int body(){
            return (int) ((high-open) * 10000);
        }
        public int tail(){
            return (int) ((close-low) * 10000);
        }

        @Override
        public String toString() {
            return "Candle{" +
                    "timestamp='" + timestamp + '\'' +
                    ", open=" + open +
                    ", low=" + low +
                    ", high=" + high +
                    ", close=" + close +
                    ", volume=" + volume +
                    '}';
        }
    }
}
