public class L7 {

    public static void main(String[] args) {
        System.out.println(pow(10,5));
        System.out.println(fak(17));
        System.out.println(Math.sin(1));
        System.out.println(sin(1));






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
    public static double sins(double x)
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
    public static double sin(double x){

        double summand = 1;
        double summe = 0;
        
        for (int k = 0; summand > 1E-15 || summand < -1E-15; k++) {
            double multiplikant = pow(-1,k);
            double zaehler = pow(x,2*k+1);
            double nenner = fak(2*k+1);
            summand = multiplikant * (zaehler / nenner);
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
}
