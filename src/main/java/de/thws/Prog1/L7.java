package main.java.de.thws.Prog1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L7 {

    public static void main(String[] args) {
        test();
    }

    public static void a1(){
        double d = 3;
        System.out.println("Math sin: "+Math.sin(d));
        System.out.println("sin: "+sin(d));
        System.out.println("ssin: "+ssin(d));
        System.out.println("cos: "+cos(d));
    }
    public static double cos(double x)
    {
        double zaehler = 1.0;
        double nenner = 1.0;
        double summe = 1.0;
        double summand = 1;
        for (int i = 2; summand > 1E-15 || summand < -1E-15; i = i + 2)
        {
            zaehler = zaehler * x * x * (-1);
            nenner = nenner * i * (i - 1);
            summand = zaehler / nenner;
            summe = summe + summand;
        }
        return summe;
    }

    public static double ssin(double x)
    {
        double zaehler = x;
        double nenner = 1;
        double summe = x;
        double summand = 1;

        for (int i = 3; summand > 1E-15 || summand < -1E-15; i = i + 2)
        {
            zaehler = zaehler * x * x * (-1);
            nenner = nenner * i * (i - 1);
            summand = zaehler / nenner;
            summe = summe + summand;
        }

        return summe;
    }

    /**
     *
     * @param x ist die Zahl in RAD
     * @return Gibt den Sinuswert von x zurück
     */
    public static double sin(double x){
        double summand = 1;
        double summe = 0;
        
        for (int k = 0; summand > 1E-15 || summand < -1E-15; k++) {
            summand = pow(-1,k) * (pow(x,2*k+1) / fak(2*k+1));
            summe += summand;
        }
        return summe;
    }

    public static double pow(double base, double exp){
        double result = 1;
        if(exp > 0) {
            for (double i = exp; i > 0; i--) {
                result *= base;
            }
        }else if( exp < 0){
            for (double i = exp; i < 0; i++) {
                result *= base;
            }
            result = 1 / result;
        }
        return result;
    }

    public static double fak(int x){
        double result = 1;
        for (int i = 1; i <= x; i++) {
            result *= i;
        }
        return result;
    }

    public static void a2(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Anzahl der Zahlen: ");
        int amount = sc.nextInt();
        if(amount <= 0){
            System.out.println("Fehlermeldung: <= 0");
            return;
        }
        double[] a = new double[amount];

        for (int i = 0; i < amount; i++) {
            System.out.print("Zahl "+(i+1)+" eingeben: ");
            a[i] = sc.nextDouble();
        }
        System.out.println("Mittelwert: "+mitte(a));
        System.out.println("Abweichung: "+abweichung(a));
        System.out.println("Max: "+max(a));
        System.out.println("Min: "+min(a));
    }
    public static double mitte(double[] a){
        double sum = 0;
        for (double v : a) {
            sum+=v;
        }
        return sum/a.length;
    }

    public static double abweichung(double[] a){
        double mittelwert = mitte(a);
//        double sum = 0;
//        for (double v : a) {
//            sum+= pow(v-mittelwert,2);
//        }
//        return Math.sqrt(sum/ a.length);

        double[] b = a.clone();
        for (int i = 0; i < a.length; i++) {
            b[i] = pow(a[i]-mittelwert,2);
        }
        return Math.sqrt(mitte(b));
    }

    public static double max(double[] a){
        double res = a[0];
        for (double v : a) {
            if(v > res){
                res = v;
            }
        }
        return res;
    }
    public static double min(double[] a){
        double res = a[0];
        for (double v : a) {
            if(v < res){
                res = v;
            }
        }
        return res;
    }


    public static void test(){
        List<String> rtWerte = new ArrayList<>();
        rtWerte.add("5");
        rtWerte.add("none");
        rtWerte.add("4");
        rtWerte.add("8");
        rtWerte.add("2");
        rtWerte.add("none");
        rtWerte.add("7");
        rtWerte.add("7");
        rtWerte.add("6");
        rtWerte.add("2");
        rtWerte.add("3");


        System.out.println(rtWerte);

        for (int i = 0; i < rtWerte.size(); i++) {
            String currentValue = rtWerte.get(i);
            if(currentValue.equals("none")){
                rtWerte.set(i+1,"deleted");
            }
        }
        System.out.println(rtWerte);

    }
}
