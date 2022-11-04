import java.util.Scanner;

public class L4 {
    public static void main(String[] args) {
        a5();
    }


    public static void a5(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Geben Sie bitte eine Zahl ein:");
        int input = sc.nextInt();

        while(input < 1 || input > 1000000){
            System.out.println("FEHLER – Zahl ist ungültig.");
            System.out.print("Geben Sie bitte eine Zahl ein:");
            input = sc.nextInt();
        }


        int temp = input;
        int result = 1;

        while(temp != 0){
            result*=temp%10;
            temp/=10;
        }


        System.out.println("Das Querprodukt der Zahl "+input+" beträgt "+result);

    }
}
