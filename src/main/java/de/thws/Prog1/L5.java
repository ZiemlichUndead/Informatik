package main.java.de.thws.Prog1;

import java.util.Scanner;

public class L5 {

    public static void main(String[] args) {
        a2();
    }

    public static void a2(){
        Scanner sc = new Scanner(System.in);
        System.out.print("b: ");
        int b = sc.nextInt();
        System.out.print("n: ");
        int n = sc.nextInt();

        double result = 1;

        boolean negative = n < 0;

        while (n != 0) {
            result *= b;

            if(n > 0){
                n--;
            }else{
                n++;
            }
        }

        if(negative){
            result = 1/result;
        }


        System.out.println("Ergebnis: "+result);
        a2();
    }
}
