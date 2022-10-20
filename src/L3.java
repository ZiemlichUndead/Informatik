import java.util.Random;
import java.util.Scanner;

public class L3 {

    public static void main(String[] args) {
       a6();

    }

    public static void a1(){
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        System.out.println("Durch 7 Teilbar: "+(input%7==0));

        double d = sc.nextDouble();
        System.out.println((d%7.5f));

        /*b)
        Bei Negativen Zahlen funktioniert Modulo normal, gibt aber bei unterschiedlichen vorzeichen negativen rest aus
        Bei Kommazahlen funktioniert Modulo auch wie gewohnt und gibt den rest (als kommazahl) aus,
        der übrig bleibt, wenn die erste Zahl ganzzahlig oft in die 2. Zahl passen soll
         */
    }

    public static void a2(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Pizza 1 Durchmesser: ");
        double pizza1Durchmesser = sc.nextDouble();
        System.out.println("Pizza 1 Preis: ");
        double pizza1Preis = sc.nextDouble();

        System.out.println("Pizza 2 Durchmesser: ");
        double pizza2Durchmesser = sc.nextDouble();
        System.out.println("Pizza 2 Preis: ");
        double pizza2Preis = sc.nextDouble();

        double pizza1Radius = pizza1Durchmesser / 2;
        double pizza2Radius = pizza2Durchmesser / 2;

        double pizza1Area = Math.PI*pizza1Radius*pizza1Radius;
        double pizza2Area = Math.PI*pizza2Radius*pizza2Radius;

        double pizza1PricePerArea = pizza1Preis / pizza1Area;
        double pizza2PricePerArea = pizza2Preis / pizza2Area;

        if(pizza2PricePerArea > pizza1PricePerArea){
            System.out.println("Pizza 1 Kostet "+pizza1PricePerArea+"€/cm² und ist damit preiswerter als Pizza 2 mit "+pizza2PricePerArea+"€/m²");
        }else{
            System.out.println("Pizza 2 Kostet "+pizza2PricePerArea+"€/cm² und ist damit preiswerter als Pizza 1 mit "+pizza1PricePerArea+"€/m²");
        }
    }

    public static void a3(){
        Scanner sc = new Scanner(System.in);
        char c = sc.next().charAt(0);

        boolean isAnything = false;
        if(Character.isUpperCase(c)){
            System.out.println("Großbuchstabe");
            isAnything = true;
        }
        if(c >= 48 && c <= 57 || c >= 65 && c <= 70 || c >= 97 && c <= 102){
            System.out.println("Hexadezimale Ziffer");
            isAnything = true;
        }
        if(c == 48 || c == 49){
            System.out.println("binäre Ziffer");
            isAnything = true;
        }
        if(c >= 48 && c <= 55){
            System.out.println("oktale Zahl");
            isAnything = true;
        }

        if(!isAnything) {
            System.out.println("Unbekannt");
        }


        a3();

    }

    public static void a4(){
        double random = Math.random();

        int wurf = 1+ (int) (random*6);

        switch (wurf){
            case 1:
                System.out.println("Eins gewürfelt");
                break;
            case 2:
                System.out.println("Zwei gewürfelt");
                break;
            case 3:
                System.out.println("Drei gewürfelt");
                break;
            case 4:
                System.out.println("Vier gewürfelt");
                break;
            case 5:
                System.out.println("Fünf gewürfelt");
                break;
            case 6:
                System.out.println("Sechs gewürfelt");
                break;
        }
        new Scanner(System.in).nextLine();
        a4();
    }

    public static void a5(){
        System.out.println("Matrikelnummer eingeben:");
        String input = new Scanner(System.in).nextLine();

        boolean isIntNumber = false;
        try{
            Integer.parseInt(input);
            isIntNumber = true;
        }catch (Exception ignored){}

        if(isIntNumber){
            if(input.length() == 7) {
                if (input.startsWith("50") || input.startsWith("51") && input.startsWith("61")) {
                    System.out.println("Du hast eine gültige Matrikelnummer eingegeben!");
                }else{

                    System.out.println("Die eingegebene Matrikelnummer ist ungültig (Fängt nicht mit 50, 51 oder 61 an)");
                }
            }else{

                System.out.println("Die eingegebene Matrikelnummer ist ungültig (Länge nichtgleich 7)");
            }
        }else{

            System.out.println("Die eingegebene Matrikelnummer ist ungültig (Keine Ganzzahl)");
        }

        a5();

    }

    public static void a6(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Jahr eingeben: ");
        int jahr = sc.nextInt();

        if(jahr % 4 == 0 && (jahr % 100 != 0 || jahr % 400 == 0)){
            System.out.println("Du hast ein Schaltjahr eingeben!");
        }else{
            System.out.println("Du hast kein Schaltjahr eingegeben!");
        }
        a6();


    }


}
