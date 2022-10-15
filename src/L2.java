import java.time.LocalDateTime;
import java.util.Scanner;

public class L2 {


    public static void main(String[] args) {

        a1();
    }

    public static void a1(){
        System.out.println("Radius eingeben: ");
        Scanner sc = new Scanner(System.in);
        double radius = sc.nextDouble();

        double a = Math.pow(radius,2)*Math.PI;
        double u = 2*Math.PI*radius;

        System.out.println("Kreis:");
        System.out.println("Fläche: "+a);
        System.out.println("Umfang: "+u);

        double v = (4d/3d)*Math.PI*Math.pow(radius,3);
        System.out.println("Kugel:");
        System.out.println("Volumen: "+v);

    }

    public static void a2(){
        Scanner sc = new Scanner(System.in);

        System.out.println("p eingeben: ");
        double p = sc.nextDouble();

        System.out.println("q eingeben: ");
        double q = sc.nextDouble();

        double inRoot = Math.pow(p / 2d, 2) - q;
        if(inRoot<0){
            System.out.println("Wurzel ist negativ, nicht berechenbar");
            return;
        }
        double root = Math.sqrt(inRoot);

        double x1 = -(p/2d) + root;
        double x2 = -(p/2d) - root;

        System.out.println("x1: "+x1);
        System.out.println("x2: "+x2);

    }

    public static void a3(){
        int h,min,sec;

        LocalDateTime now = LocalDateTime.now();
        h = now.getHour();
        min = now.getMinute();
        sec = now.getSecond();

        int elapsedSeconds = h*60*60 + min*60 + sec;
        int totalSeconds = 24*60*60;
        double dayPercent = (double) elapsedSeconds / totalSeconds * 100;

        System.out.println("Es sind "+elapsedSeconds+" Sekunden nach Mitternacht");
        System.out.println("Es sind "+(totalSeconds-elapsedSeconds)+" Sekunden vor Mitternacht");
        System.out.println("Prozent des Tages: "+dayPercent+"%");

    }

}