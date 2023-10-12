package de.thws.AlgoDat2;

public class Fibonacci {

    public static void main(String[] args) {

        int which = 6;

        long time = System.currentTimeMillis();
        long fibbo = fibboIter(which,0,1);
        System.out.println(fibbo);
        System.out.println("Iter Time: "+(System.currentTimeMillis()-time));

        time = System.currentTimeMillis();
        fibbo = fibboRek(which);
        System.out.println(fibbo);
        System.out.println("Rek Time: "+(System.currentTimeMillis()-time));
    }

    public static long fibboRek(long n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fibboRek(n-1) + fibboRek(n-2);
    }

    public static long fibboIter(long n, long last1, long last2){
        if(n == 1){
            return last2;
        }
        return fibboIter(n-1,last2,last1+last2);
    }
}
