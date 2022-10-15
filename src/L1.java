public class L1 {

    public static void main(String[] args) {
        int x = 5;
        int y = 7;
        //Vor dem Tausch
        System.out.println(x);
        System.out.println(y);
        //Tausch

        int cache = x;
        x = y;
        y = cache;

        //Nach dem Tausch
        System.out.println(x);
        System.out.println(y);
    }
}
